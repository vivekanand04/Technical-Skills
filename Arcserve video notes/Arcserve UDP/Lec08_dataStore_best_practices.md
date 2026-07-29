**1.Hash Drive is Full – How to Change/Move its location?**



When hash path is full, there might be a requirement to change it to another path. DO NOT move files manually; UDP UI supports changing the hash path by modifying data store. We strongly suggest to use this feature.



\- Crisp Explanation:

&#x20; If the hash storage disk becomes full, change the hash destination using the Arcserve UDP UI instead of manually moving files.



Refer the following section in Arcserve Unified Data Protection 7.0 Solutions Online Help,



○ How to Switch the Hash Destination Modes

&#x20; - Crisp Explanation:

&#x20;   Steps to change or switch the hash storage mode/location.



○ Modify Only the Hash Destination

&#x20; - Crisp Explanation:

&#x20;   Allows changing only the hash path without modifying other datastore components.



**2.Plan for follow-up tasks so that there is a secondary copy.**



○ Look at the available follow-up tasks to a have the backed up data Copied/Replicated to another Location/RPS Server using Replication/Copy Recovery Point/Copy to Tape/Data store backup to tape. Based on the requirement you may also configure Virtual Stand-by and Assured Recovery Tasks.



&#x20; - Crisp Explanation:

&#x20;   Configure follow-up tasks to create a secondary backup copy on another location or RPS server for better disaster recovery and data protection.



○ Refer Solution guide for more details.



&#x20; - Crisp Explanation:

&#x20;   Check the Arcserve solution guide for detailed configuration and implementation steps.





**3.Data Corruption - Symptoms**



○ This section discusses about the Symptoms related to Dedupe Data Corruption. The error message seen in the activity log may not always report that there is data corruption in the data store. The jobs such as Catalog, Virtual Stand-by, Restore, BMR, Merge, Replication, ASBU-UDP Lite Integration, Copy to Tape may report read errors. The jobs such as Backup, Merge, and Replication may report write errors. Sometimes the Data Store may not start due to Hash DB Corruption.



&#x20; - Crisp Explanation:

&#x20;   Deduplication datastore corruption can cause read/write failures, restore issues, merge failures, replication problems, or Hash DB startup failures.



○ Some sample error messages,



&#x20; ▪ Catalog Jobs -> Failed to read the drive.

&#x20;   Read data from virtual disk failed. (Volume=\[E:], EC=\[10102])



&#x20;   - Crisp Explanation:

&#x20;     Catalog or restore process failed while reading backup data from the virtual disk.



&#x20; ▪ Backup \\ Replication Jobs -> Failed to write to destination. System error=\[The file or directory is corrupted and unreadable. (1392)].



&#x20;   - Crisp Explanation:

&#x20;     Backup or replication failed because the datastore files or destination storage became corrupted.



&#x20; ▪ Merge Jobs -> Failed to merge virtual disk. Internal Error=\[INVALID PARAMETER].



&#x20;   - Crisp Explanation:

&#x20;     Merge operation failed due to corrupted metadata or invalid deduplication datastore information.





**4.Data Corruption – Probable Causes**



○ Data Store Corruption could be related to several environmental factors or sometimes related to UDP Software. Analysing the event logs would give us some clue about the environmental problems.



&#x20; - Crisp Explanation:

&#x20;   Datastore corruption can happen because of hardware, network, user mistakes, or software-related issues.



&#x20; ▪ Permission/Access

&#x20;   - Crisp Explanation:

&#x20;     Incorrect file or folder permissions can prevent datastore access and cause corruption.



&#x20; ▪ Disk I\\O Or Corruption (Disk which has the Backup Destination folders)

&#x20;   - Crisp Explanation:

&#x20;     Disk read/write failures or physical disk corruption can damage backup datastore files.



&#x20; ▪ Network

&#x20;   - Crisp Explanation:

&#x20;     Network interruptions during backup or replication may corrupt transferred data.



&#x20; ▪ RPS Server Crash \\ Frequent Reboots \\ Shutdown \\ Power Failure

&#x20;   - Crisp Explanation:

&#x20;     Unexpected RPS shutdowns or crashes can interrupt datastore operations and corrupt files.



&#x20; ▪ Backup Destination Server Crash \\ Frequent Reboots \\ Shutdown \\ Power Failure

&#x20;   - Crisp Explanation:

&#x20;     Backup destination server instability can lead to incomplete or damaged datastore writes.



&#x20; ▪ User Error (Moving, Deleting, Renaming or Replacing files manually)

&#x20;   - Crisp Explanation:

&#x20;     Manual modification of datastore files can break datastore consistency.



&#x20; ▪ User Error (Removing the Backup Destination related disks when the Data Store is running)

&#x20;   - Crisp Explanation:

&#x20;     Disconnecting datastore disks while services are running may corrupt active data.



&#x20; ▪ UDP Software Bug

&#x20;   - Crisp Explanation:

&#x20;     In some cases, software defects in Arcserve UDP may also cause datastore corruption.





**5.Data Corruption – Avoid/Prevent**



1\. Dedupe data store has 4 paths (Backup destination folder, Data path, Index path, Hash path). DO NOT manually copy any individual files from one data store destination path to another destination path (including data store verification file) unless you get direct guidance from Engineering Team.



&#x20;  - Crisp Explanation:

&#x20;    Never manually move or copy datastore files between datastore locations because all datastore components are internally linked.



&#x20;  ○ There are some files in the Backup Destination, Data, Index and Hash paths which must match to be able to import or start the data store successfully.



&#x20;    - Crisp Explanation:

&#x20;      Backup, Data, Index, and Hash files must remain synchronized for the datastore to work properly.



&#x20;  ○ Multiple data corruption issues have been caused by this kind of operation.



&#x20;    - Crisp Explanation:

&#x20;      Manual file movement is a common cause of datastore corruption.



2\. When hash path is full, there might be a requirement to change it to another path. DO NOT move files manually; UDP UI supports changing the hash path by modifying data store. We strongly suggest to use this feature.



&#x20;  - Crisp Explanation:

&#x20;    If the hash storage becomes full, use the Arcserve UDP UI to change the hash location safely.



&#x20;  ○ Refer the following section in Arcserve Unified Data Protection 7.0 Solutions Online Help,



&#x20;    ▪ How to Switch the Hash Destination Modes

&#x20;      - Crisp Explanation:

&#x20;        Steps for changing the hash storage mode or destination.



&#x20;    ▪ Modify Only the Hash Destination

&#x20;      - Crisp Explanation:

&#x20;        Allows changing only the hash location without affecting the remaining datastore paths.



3\. Avoid manually copying data store paths from one location to another location. In some cases when the disk is full, there may be a requirement to copy. Say for example: - When index path is full, there may be a requirement to copy it to another location and then import.



&#x20;  - Crisp Explanation:

&#x20;    Do not manually move datastore folders unless officially required during low disk space situations.



&#x20;  ○ Refer the following section in Arcserve Unified Data Protection 7.0 Solutions Online Help,



&#x20;    ▪ How to change the data store destination paths when One or Multiple folders are Full?



&#x20;      - Crisp Explanation:

&#x20;        Provides steps to safely move datastore paths when storage becomes full.



&#x20;    ▪ Modify Hash Path



&#x20;      - Crisp Explanation:

&#x20;        Allows safely changing only the hash storage location.



&#x20;  ○ Important:-



&#x20;    While doing the above mentioned steps,



&#x20;    ▪ DO NOT start the datastore until all the steps are complete.



&#x20;      - Crisp Explanation:

&#x20;        Start the datastore only after the migration process finishes completely.



&#x20;    ▪ DO NOT modify any files manually in the new path.



&#x20;      - Crisp Explanation:

&#x20;        Manual file editing may break datastore consistency.



&#x20;    ▪ After importing data store to link to the new location and starting the data store, DO NOT switch back to the original path. This may cause data corruption.



&#x20;      - Crisp Explanation:

&#x20;        Once datastore is linked to the new path, avoid reverting to the old location.







4\. DO NOT unplug the storage device which has any of the Data Store paths while the Data Store is running.



&#x20;  - Crisp Explanation:

&#x20;    Disconnecting storage during datastore activity may corrupt backup data.



5\. Configure the anti-virus setting to set the Recovery Point Server (RPS) Data Store location in the exclusion list. This is to avoid unexpected deletion of any data store related file by the Anti-Virus software.



&#x20;  - Crisp Explanation:

&#x20;    Antivirus scanning should exclude datastore folders to prevent accidental file deletion.



6\. Perform regular health check on the disks which are configured as the Data Store Destination Paths.



&#x20;  - Crisp Explanation:

&#x20;    Regular disk health monitoring helps prevent corruption caused by hardware failures.



7\. DO NOT select the option “Hash Destination is on a Solid State Drive (SSD)” when the disk is not an Actual SSD Disk or when the location is a Share Path.



&#x20;  - Crisp Explanation:

&#x20;    Incorrect SSD configuration may affect datastore performance and stability.



8\. DO NOT enable Windows Compression\\Windows Deduplication on the Disk which has any of the Backup Destination folders.



&#x20;  - Crisp Explanation:

&#x20;    Windows compression or deduplication can interfere with Arcserve datastore operations and may lead to corruption.



**6. Troubleshooting Data Corruption / Troubleshooting Steps**



**Troubleshooting Steps**



○ Information Gathering



&#x20;  ▪ Information gathering is very important as it would be the basis for further research and would be helpful to find the cause of the problem.



&#x20;  ▪ Collect the FCG along with the Problem Description, Error Message, Environment Details and required logs.

&#x20;    (Refer the “Arcserve UDP Dedupe Data Store Corruption – Troubleshooting Essentials” guide for detailed information.)



○ Analyze Logs



&#x20;  ▪ Analyse the log specific to the job and the node.

&#x20;    (Ex: - Backup \\ Merge \\ Replication \\ VSB \\ BMR \\ Restore)



&#x20;  ▪ Start the analysis from the time the problem started happening and events before the problem started happening. This would give us a clue on why the problem happened.



&#x20;  ▪ Analyse the DataStoreService logs, GDDServer logs, Windows Event Logs.



&#x20;  ▪ If the Read\\Write problem happens on a single node or multiple nodes, or if you suspect data corruption during log analysis, run Scan command like CheckRecoveryPoint as the first step.



○ Troubleshooting



&#x20;  ▪ Upgrade to the Arcserve UDP 7.0 Update 1 as it has several enhancements related to the data store.



&#x20;  ▪ Run CheckRecoveryPoint Scan.



&#x20;  ▪ If CheckRecoveryPoint scan reports corruption, proceed to next step.



&#x20;  ▪ Stop the data store and run VerifyAll scan.



&#x20;  ▪ Result would show the list of nodes that have corrupted recovery points if there is corruption.



&#x20;  ▪ Run RebuildHash.



&#x20;  ▪ In some cases, the RebuildHash result would show the list of nodes that have corrupted recovery points if there is corruption.



&#x20;  ▪ Rename the node folder name in the backup destination for the nodes that reported corruption in the VerifyAll and RebuildHash operation.



&#x20;  ▪ Start the data store and run the jobs.



&#x20;  ▪ Analyse and recommend customer to fix any environmental issues as the problem may reoccur if there is an environmental problem.



○ Important Points to remember:-



&#x20;  ▪ Continuing with a corrupted Data Store, may cause problems at the time of a Restore.



&#x20;  ▪ If the customer just renames the node folder name for now, critical data corruption issues may reappear after some time.



&#x20;  ▪ Even if the customer/L2/development engineer suggests to create a new data store, it is very important that we provide the probable cause for corruption. If not, the corruption may occur on the new Data Store after some time.



&#x20;  ▪ If space is not a constraint, the corrupted data store could be kept in Stopped State, so that it could be used for restore purpose.



&#x20;  ▪ DO NOT rename, move, replace or delete any files or folders in any of the Backup Destination folders without guidance from the engineering team.



○ Refer the “Arcserve UDP Dedupe Data Store Corruption – Troubleshooting Essentials” guide for detailed information.





**7.Troubleshooting Data Corruption / Data Store is Out of Service**



**Data Store is Out of Service**



The data store is not functioning properly. You cannot submit any jobs in this state. Stop the data store and verify the reason for this behavior. The following cases can result in the Out of Service status of a data store:



○ The data store backup destination cannot be accessed.



○ The configurations in registry or file are corrupted.



○ The GDD index or data role has internal errors.



○ The GDD index or data role process is manually stopped.



○ Windows Defender or Anti-Virus has quarantined or deleted UDP data files or other files from the UDP destination paths.



○ Analyze the DataStoreService logs, GDDServer logs, Windows Event Logs, and AV logs to find the cause and fix the problem.



**8.Purge and Disk Reclamation Troubleshooting / Reasons**



**Reasons for slow reclamation or space reclamation problems**



○ Reasons why the purge \\ disk reclamation could not reclaim space or runs slowly.



&#x20;  ▪ Understanding about the time taken to perform purge/disk reclamation and Global Deduplication.



&#x20;  ▪ Redundant data generated on dedupe data store.



&#x20;    Why is redundant data generated on dedupe data store?



&#x20;    It is to avoid data corruption in case of abnormal events,



&#x20;      • RPS node is forcibly powered off when there is ongoing backup/replication jobs.



&#x20;      • Dedupe data store is forcibly stopped when there is ongoing backup/replication jobs.



&#x20;      • Disk is disconnected.



&#x20;      • Network is broken when there is ongoing backup/replication jobs.



&#x20;      • Dedupe hash role could not respond within the default timeout when Identifying obsolete data blocks process updates hash keys.



&#x20;      • User manually deleting node related folder from the Backup Destination.



&#x20;  ▪ Orphaned Index Files.



&#x20;      • During certain failures, some “.index” files could have been orphaned under certain circumstances and could not be detected by the subsequent purge process. Though this is not common, we have command line tools to identify these type of Index files and purge. This should be performed under the guidance of support.





○ Reasons why the purge \\ disk reclamation could not reclaim space or runs slowly.



&#x20;  ▪ Identifying obsoleted data blocks phase runs slow.



&#x20;    Sometimes, “identifying obsoleted data block phase” runs very slow. “-Purge Status” finds that someone item keeps for many hours. In this case, please think about the following.



&#x20;      • Is the index file very big? I.e. the “.index” file might contain many entries.



&#x20;      • Is the SSD slow? As we know, “identifying obsoleted data block phase” needs to query hash database to decrease reference number by 1 for every entry in the “.index” file. If SSD is slow, it might cost much time.



&#x20;      • Are there many concurrent jobs running on the data store? If yes, they might compete disk IO with “identifying obsoleted data block phase”.



&#x20;      • Is the hash database close to full? If yes, in this case, “identifying obsoleted data block phase” would be very slow due to that hash database has to frequently do backend bucket merging. So, please check whether SSD still has enough free space or not; please check whether the specified memory usage by “memory allocation” is used up or not.



&#x20;  ▪ NAS Destination – Sparse Mode not supported.



Following command line utilities were used for troubleshooting space reclamation problems until UDP 6.5 Update 4, these were used after analysing the environment and logs.



○ Purge orphan index files using the GetGddFileNo/PurgeGddFile commands.



○ Purge invalid ref files using the PurgeInvalidRefFile scan,



&#x20;  as\_gddmgr.exe -Scan PurgeInvalidRefFile DataStoreName



○ Purge invalid data files using the PurgeInvalidDataFile scan,



&#x20;  as\_gddmgr.exe -Scan PurgeInvalidDataFile DataStoreName



○ Refresh statistical information related to disk usage information.



&#x20;  as\_gddmgr.exe –Scan RefreshDiskUsageInfo DataStoreName



○ Rebuild Hash.





**9. Arcserve UDP 7.0 Tools / Arcserve UDP Performance Test Utility**



**Arcserve UDP Performance Test Utility - Internal**



○ The “ArcserveUDPPerformanceTest” tool would be helpful to test the data store disk performance and decide the appropriate thread number for VerifyData/VerifyAll/RebuildIndex on the given environment.



○ Refer the following KB for more details, https://support.arcserve.com/s/article/KB000009018. This is an Internal article and is shared with the customer on a need basis.



○ Launch the tool “ArcserveUDPPerformanceTest.exe”.



○ Stop the data store before performing the tests.



○ Click Start under SHA1 Performance to perform SHA1 performance test. This test would be based on the logical processors and determines the thread number to perform SHA1 calculation to generate hash. The results would be updated in the log file called “Test\_Perf\_<MachineName>”, this log file would be in the same folder where the tool was extracted. The SHA1 performance test results would be helpful in analyzing the performance related to SHA1 calculation to generate hash.





Sample log analysis



Based on the sample log below, thread count 4 gives higher read speed compared to other threads, hence thread number 4 could be used in VerifyData/VerifyAll scan or RebuildIndex.



2019-02-16 14:42:07:0734 \[33308] Data file path\[E:\\TestDataStore\\Data], total data files\[4477], total data size\[2754266313776], each read test will read data size\[116704014336]



2019-02-16 14:46:27:0013 \[33888] Thread count\[1], read time\[259 sec], data size\[111297.73M], read speed\[429.26 M/s].



2019-02-16 14:49:03:0483 \[33888] Thread count\[2], read time\[156 sec], data size\[111297.91M], read speed\[711.31 M/s].



2019-02-16 15:19:20:0870 \[23472] Thread count\[4], read time\[125 sec], data size\[111158.30M], read speed\[885.39 M/s].



○ ThreadCount switch in VerifyData/VerifyAll and RebuildIndex



&#x20;  ▪ The ThreadCount switch in VerifyData/VerifyAll and RebuildIndex would allow user to specify the number of threads to concurrently process multiple pairs of ref/data files.



&#x20;  ▪ as\_gddmgr.exe –Scan VerifyData <DataStoreName> -ThreadCount <X>



&#x20;  ▪ as\_gddmgr.exe –Scan VerifyAll <DataStoreName> -ThreadCount <X>



&#x20;  ▪ as\_gddmgr.exe –Scan RebuildIndex <DataStoreName> -ThreadCount <X>



&#x20;  ▪ Note: Do not enable multiple thread mode if the data store destination disk is not powerful enough, multiple thread mode might degrade the performance of VerifyData/VerifyAll due to extra disk seek.





**10. Arcserve UDP 7.0 Tools / Rebuild Index**



**Rebuild Index - Internal**



Note: Details about this tool is not documented and not displayed in the Command line usage/examples.



What can RebuildIndex do?



○ It removes the obsolete entries in ref files.



○ It removes the obsolete entries in data files.



○ It automatically deletes the corrupt index files and ref files. At the end, it would report which nodes are impacted by the corrupt files.



○ It deletes orphan index files.



○ It inline executes RebuildHash and RefreshDiskUsageInfo.



○ Disk fragmentation of index / ref / data files would be effectively decreased. As a result, it might help on performance improvement of the subsequent UDP jobs on the data store.







How long would the RebuildIndex scan run?



○ RebuildIndex might be time-consuming if data store is large and every file needs to be rebuilt, it might take a lot of time, which could lead to inconvenience as the datastore needs to be stopped. User can specify the “%” to partially scan the dataset. He can perform n number of RebuildIndex cycles in different time frames.



○ Once it is started, user must wait for it to complete. Otherwise, the data store would not be usable due to the data inconsistency across dedupe folders.







&#x20;

Rebuild Index - Internal



Syntax



as\_gddmgr.exe -Scan RebuildIndex DataStoreName -ThreadCount \[1\~32]



(Specify the value for ThreadCount based on the analysis done using “ArcserveUDPPerformanceTest” tool.)



▪ By default, the displayed % range is from 10% to 90%.



▪ If “-AnyPercentage Yes” switch is specified, the displayed % range is from 0% to 100%.



&#x20;  as\_gddmgr.exe -Scan RebuildIndex DataStoreName -ThreadCount \[1\~32] -AnyPercentage \[Yes]



▪ The % number just controls how many ref/data file pairs would be rebuilt. Other steps would be executed as normal no matter what % number is specified.

