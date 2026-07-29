**1.Why do we need Purge and Disk Reclamation?**

**==========================================**



○ In deduplication backup, old recovery points may get deleted or merged.

&#x20; ▪ But the actual data blocks are not removed immediately because multiple backups may still reference the same blocks.



○ Purpose of Purge

&#x20; ▪ Removes references/index entries of expired or deleted backup sessions.

&#x20; ▪ Decreases reference count of unused blocks.

&#x20; ▪ Marks unused blocks as "holes".



○ Purpose of Disk Reclamation

&#x20; ▪ Frees actual physical disk space occupied by unused blocks.

&#x20; ▪ Deletes completely unused data files.

&#x20; ▪ Reorganizes partially used files to recover storage efficiently.



○ Why both are needed

&#x20; ▪ Purge only marks unused data logically.

&#x20; ▪ Disk Reclamation physically recovers storage space from disk.



○ Without Purge and Reclamation

&#x20; ▪ Storage usage keeps increasing.

&#x20; ▪ Deleted backups still consume disk space.

&#x20; ▪ Deduplication datastore becomes inefficient and large.





**2. Purge And Disk Reclamation**

**==========================**



Purge and reclamation is another topic involving plenty of optimization and error-handling. Long story short, it contains 3 phases:



1\. Fast Purge:

&#x20;  At the end of merge job, index file of the session will be renamed and marked as “ToPurge” state in file Purge.gdd. Then merge job could immediately finish and leave the remaining work to roles of deduplication server.



&#x20;  - Crisp Explanation:

&#x20;    Quickly marks old backup data for deletion without deleting immediately.



2\. Real Purge:

&#x20;  Once a session is added into Purge.gdd, index role will trigger a thread to scan all its index entries and decrease their reference counts as a purge operation. If some entry’s reference count equals 0, meaning its data is no longer required by any session, the data block should be marked as “hole” and reclaimed later.



&#x20;  - Crisp Explanation:

&#x20;    Removes references of unused backup blocks and marks unused blocks as holes.



3\. Disk Reclamation:

&#x20;  reclaiming thread is automatically triggered every 6 hours (or manually triggered by “as\_gddmgr.exe -Purge” command) to check whether there’s data file with holes to reclaim. If true, it would reclaim disk space in 3 scenarios:



&#x20;  1) If all data blocks become holes, simply delete entire data file.



&#x20;  2) If less than 50% blocks become hole, leverage sparse mode to quickly reclaim their spaces.



&#x20;  3) If more than 50% block become hole, read valid blocks and write into a new one.



&#x20;  - Crisp Explanation:

&#x20;    Reclaims actual disk space by removing or reorganizing unused deduplicated blocks.



**3.Purge And Disk Reclamation**

**==========================**



○ When the following events occur, it would make an API call to perform the purge operation.



&#x20;   ▪ Merge job completed.

&#x20;     - Crisp Explanation:

&#x20;       Purge starts after backup merge operation finishes.



&#x20;   ▪ Backup\\Replication job failure happens.

&#x20;     - Crisp Explanation:

&#x20;       Failed jobs can also trigger purge handling.



○ Merge job would run on the RPS Server.

&#x20; - Crisp Explanation:

&#x20;   Merge operations are processed at the Recovery Point Server.



○ Purge and disk reclamation is done in different phases.



&#x20;   ▪ Fast Purge

&#x20;     - Crisp Explanation:

&#x20;       Quickly marks expired sessions for cleanup.



&#x20;   ▪ Identifying obsoleted data blocks

&#x20;     (Previously this was referred as Real Purge. GDD logs may still refer to this as Real Purge.)

&#x20;     - Crisp Explanation:

&#x20;       Finds unused deduplicated blocks no longer referenced by backups.



&#x20;   ▪ Disk Reclamation

&#x20;     - Crisp Explanation:

&#x20;       Frees actual physical disk space occupied by unused blocks.





**4.Purge And Disk Reclamation**

**==========================**



○ By default, the process would be automatically suspended when the regular UDP jobs run. This is to avoid that identifying obsoleted data blocks/disk reclamation impacts the throughput of the regular UDP jobs. Once the regular UDP jobs are completed, Identifying obsoleted data blocks/disk reclamation would be automatically resumed.



&#x20; - Crisp Explanation:

&#x20;   Purge and disk reclamation pause during active backup jobs to avoid performance impact and resume automatically after jobs finish.



○ But there is a command line option to enable Identifying obsoleted data blocks/disk reclamation run in parallel with regular UDP jobs. There are complicated sync mechanisms between the process and the regular UDP jobs in case that they run in parallel.



&#x20; - Crisp Explanation:

&#x20;   Arcserve UDP can run purge/reclamation together with backup jobs using command-line options, but synchronization handling becomes complex.



**5.Deduplication – as\_gddmgr Tool**



○ Lets you check data integrity at recovery point level and data store level for deduplication data stores.

&#x20; ▪ Crisp Explanation:

&#x20;   Checks backup and datastore consistency/integrity.



○ You can use this tool to regenerate a hash database in case of a hash database failure. You can also use this tool to query and manage the backend purge and disk reclamation for deduplication data stores.

&#x20; ▪ Crisp Explanation:

&#x20;   Helps rebuild hash DB and manage purge/disk reclamation operations.



○ The output of the command is displayed on the Windows command console. The tool also generates a log file in the “Logs” folder. For example, as\_gddmgr\_2014\\9-4\_11-14-22-655.log is a log file that contains all details.

&#x20; ▪ Crisp Explanation:

&#x20;   Command results are shown in console and stored in log files.



○ Location: You can find as\_gddmgr.exe in the "Bin" folder of the UDP installation path.

&#x20; ▪ Crisp Explanation:

&#x20;   The executable file is available inside the UDP Bin directory.





**6. Deduplication – as\_gddmgr Tool – CheckRecoveryPoint Scan**



○ CheckRecoveryPoint



&#x20; ▪ Rehydrates the specified recovery point(s) as full, then checks data integrity.

&#x20;   - Crisp Explanation:

&#x20;     Restores the selected recovery point temporarily and verifies backup integrity.



&#x20; ▪ This command can be run when the data store is running.

&#x20;   - Crisp Explanation:

&#x20;     Scan can run without stopping the datastore service.



&#x20; ▪ Examples:



&#x20;   as\_gddmgr.exe -Scan CheckRecoveryPoint DataStoreName -Node myComputer -RecoveryPoint 18



&#x20;   as\_gddmgr.exe -Scan CheckRecoveryPoint DataStoreName -Node All -RecoveryPoint Latest



&#x20;   - Crisp Explanation:

&#x20;     Used to scan a specific recovery point or the latest recovery point for all nodes.



**7.Deduplication – as\_gddmgr Tool – VerifyRefCount Scan**



○ VerifyRefCount



&#x20; ▪ Scans index files and reference files to verify reference count recorded in the hash database.

&#x20;   - Crisp Explanation:

&#x20;     Checks whether reference counts in Hash DB are correct.



&#x20; ▪ The index and ref files are scanned one by one.

&#x20;   - Crisp Explanation:

&#x20;     Each index and reference file is verified individually.



&#x20; ▪ For every “.ref” file, there will be one “.refcount” file generated. This “.refcount” file would be temporarily stored in the “TEMP\_INDEX” folder.

&#x20;   - Crisp Explanation:

&#x20;     Temporary refcount files are created during verification.



&#x20; ▪ The “.refcount” file would record the exact reference number of every unique data block. This is done by scanning all of “.index” files.

&#x20;   - Crisp Explanation:

&#x20;     Counts how many backups are using each unique block.



&#x20; ▪ Finally, it would compare the reference number in “.refcount” file against these reference count stored in the hash database.

&#x20;   - Crisp Explanation:

&#x20;     Compares actual counts with stored hash database values.



&#x20; ▪ The deduplication data store should be stopped manually before running this scan.

&#x20;   - Crisp Explanation:

&#x20;     Datastore service must be stopped before execution.



&#x20; ▪ Command:

&#x20;   as\_gddmgr.exe -Scan VerifyRefCount DataStoreName



&#x20;   - Crisp Explanation:

&#x20;     Command used to run VerifyRefCount scan on a datastore.





**8.Deduplication – as\_gddmgr Tool – VerifyData Scan**



○ VerifyData



&#x20; ▪ Scans data files and then regenerates the hash keys by comparing this with the reference file.

&#x20;   - Crisp Explanation:

&#x20;     Reads backup data and regenerates hash values for verification.



&#x20; ▪ VerifyData needs to read out the data block then generate hash key for the data block. The generated hash key is based on the data block which is read out from destination disk. Let us call the hash key as “hash key 1”.

&#x20;   - Crisp Explanation:

&#x20;     Hash key 1 is newly generated from actual stored backup data.



&#x20; ▪ Then, VerifyData also would read out the hash key of the specific data block from “.ref” file. The hash key in “.ref” file was generated and written into “.ref” file during backup/replication job. Let us call the hash key as “hash key 2”.

&#x20;   - Crisp Explanation:

&#x20;     Hash key 2 is the original hash stored during backup creation.



&#x20; ▪ VerifyData would compare “hash key 1” against “hash key 2”. If they are not identical, it means data corruption.

&#x20;   - Crisp Explanation:

&#x20;     If both hash values mismatch, backup data is corrupted.



○ The deduplication data store should be stopped manually before running this scan.

&#x20; ▪ Crisp Explanation:

&#x20;   Datastore service must be stopped before running VerifyData.



○ Command:



&#x20; ▪ as\_gddmgr.exe -Scan VerifyData DataStoreName –Password xxxxxx



&#x20;   - Crisp Explanation:

&#x20;     Command used to run VerifyData scan on a datastore.





**9.Deduplication – as\_gddmgr Tool – VerifyAll Scan**



○ VerifyAll



&#x20; ▪ Performs both the VerifyRefCount and VerifyData operations.

&#x20;   - Crisp Explanation:

&#x20;     Runs both reference-count validation and data integrity verification together.



&#x20; ▪ The deduplication data store should be stopped manually before running this scan.

&#x20;   - Crisp Explanation:

&#x20;     Datastore service must be stopped before execution.



&#x20; ▪ This would be a time consuming operation as it would have to run VerifyRefCount scan and then VerifyData scan.

&#x20;   - Crisp Explanation:

&#x20;     Takes longer because both scans are executed sequentially.



&#x20; ▪ Command:



&#x20;   as\_gddmgr.exe -Scan VerifyAll DataStoreName –Password xxxxxx



&#x20;   - Crisp Explanation:

&#x20;     Command used to run complete datastore verification.



**10.Deduplication – as\_gddmgr Tool – Rebuild Hash**



○ RebuildHash



&#x20; ▪ Specify data store name and then regenerate the hash database by scanning index and reference files. The deduplication data store should be stopped manually before running this command.

&#x20;   - Crisp Explanation:

&#x20;     Recreates the Hash DB using existing index and ref files.



&#x20; ▪ Command:



&#x20;   as\_gddmgr.exe -Scan RebuildHash DataStoreName



&#x20;   as\_gddmgr.exe -Scan RebuildHash DataStoreName -NewHashPath C:\\NewHashPath



&#x20;   - Crisp Explanation:

&#x20;     Commands used to rebuild hash database, optionally using a new hash path.



○ RebuildHashWithIndexPath



&#x20; ▪ Specify the deduplication index path and then regenerate the hash database by scanning index and reference files. The option is used only when the data store is not present on any recovery point servers.

&#x20;   - Crisp Explanation:

&#x20;     Rebuilds Hash DB directly from index path when datastore is unavailable on RPS.



&#x20; ▪ Command:



&#x20;   as\_gddmgr.exe -Scan RebuildHashWithIndexPath D:\\GDDDataStore\\Index -NewHashPath D:\\NewHashPath



&#x20;   - Crisp Explanation:

&#x20;     Command used to rebuild hash database from a specified index location.





**11. Deduplication – as\_gddmgr Tool – Purge Options**



○ Start



&#x20; ▪ Enables running the purge and disk reclamation in parallel with other regular Arcserve UDP jobs. Running purge in parallel may cause throughput degradation of regular Arcserve UDP jobs.

&#x20;   - Crisp Explanation:

&#x20;     Starts purge/disk reclamation along with normal UDP jobs, but performance may reduce.



&#x20; ▪ Command:



&#x20;   as\_gddmgr.exe -Purge Start GDDDataStore1



&#x20;   - Crisp Explanation:

&#x20;     Command used to start purge operations.



○ Stop



&#x20; ▪ Disables running the purge and disk reclamation in parallel with other regular Arcserve UDP jobs.

&#x20;   - Crisp Explanation:

&#x20;     Stops parallel purge/disk reclamation execution.



&#x20; ▪ Command:



&#x20;   as\_gddmgr.exe -Purge Stop GDDDataStore1



&#x20;   - Crisp Explanation:

&#x20;     Command used to stop purge operations.



○ Status



&#x20; ▪ Queries the status of purge or disk reclamation.

&#x20;   - Crisp Explanation:

&#x20;     Checks whether purge/disk reclamation is running or stopped.



&#x20; ▪ Command:



&#x20;   as\_gddmgr.exe -Purge Status GDDDataStore1



&#x20;   - Crisp Explanation:

&#x20;     Command used to view purge operation status.





**12.Deduplication – as\_gddmgr Tool – Purge Options**



○ StartToIdentifyObsoletedData



&#x20; ▪ Enables running the purge and disk reclamation in parallel with other regular Arcserve UDP jobs. This option starts identifying obsolete data phase. The option is useful if that user wants to skip the ongoing disk reclamation phase.

&#x20;   - Crisp Explanation:

&#x20;     Starts only the obsolete data identification phase while allowing normal UDP jobs to continue running.



&#x20; ▪ Commend:

&#x20;   as\_gddmgr.exe -Purge StartToIdentifyObsoletedData DataStoreName



&#x20;   - Crisp Explanation:

&#x20;     Command used to start identifying obsolete/unreferenced data blocks.



○ Note:

&#x20; Be aware that the following options might run for a long time because the operation scans many files in the deduplication data store.



&#x20; VerifyRefCount, VerifyData, VerifyAll, RebuildHash, RebuildHashWithIndexPath



&#x20; - Crisp Explanation:

&#x20;   These operations are time-consuming because they scan and verify large amounts of deduplication metadata and data files.





**13.Deduplication – as\_gddmgr Tool – Purge Options**



○ StartToReclaim



&#x20; ▪ Enables running the purge and disk reclamation in parallel with other regular Arcserve UDP jobs.

&#x20;   - Crisp Explanation:

&#x20;     Allows purge and disk cleanup to run together with normal backup jobs.



&#x20; ▪ This option skips the identify obsolete data phase that finds out the obsolete data block, and then directly start disk reclamation phase, which free up the disk space.

&#x20;   - Crisp Explanation:

&#x20;     Directly starts reclaiming disk space without first identifying all obsolete blocks.



&#x20; ▪ The side effect of this option is that it might degrade the efficiency of the disk reclamation because the identify obsolete data phase might find out more obsolete data blocks in the data files, but the disk reclaim does not wait for the identify obsolete data phase to complete. In addition, running purge in parallel might cause the throughput degradation of regular Arcserve UDP jobs.

&#x20;   - Crisp Explanation:

&#x20;     Faster cleanup but may reduce reclamation efficiency and can slow down regular UDP backup jobs.



&#x20; ▪ Command:

&#x20;   as\_gddmgr.exe -Purge StartToReclaim DataStoreName



&#x20;   - Crisp Explanation:

&#x20;     Command used to directly start disk reclamation for the specified datastore.

