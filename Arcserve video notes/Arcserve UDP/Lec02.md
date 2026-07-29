**1.Snapshot in Arcserve UDP**

========================



1\. Definition

&#x20;  ------------

&#x20;  - A snapshot is a point-in-time copy of a system, disk, or virtual machine.

&#x20;  - It captures the exact state of data at the moment backup starts.

2.How Snapshot Works

&#x20;  -------------------

&#x20;  a) Arcserve UDP requests a snapshot.

&#x20;  b) System temporarily freezes write operations for a very short time.

&#x20;  c) Snapshot of current disk state is created.

&#x20;  d) Backup reads data from the snapshot instead of live files.

3\. if we want to backup the data of c drive then snapshot is created on c drive only under the folder name "system volume information"- ahidden file typically not visisble

4\. if the files inside the log folder( in c drive) ot deleted hten only udp can backup this one because snapshot have the information about the files in log...this is possible because of a techinique called Copy-on-Write (COW) Snapshot.





**2.Four are  types of logs**- 1) backup log 2) log inside c drive 3) Application log present at C:\\Program Files\\Arcserve\\Unified Data Protection\\Logs3) activity log(inside the view log) in arcserve agent app



**3. 1.ArcVolTrc.dat is a tracking/bitmap** file created by Arcserve UDP.Helps Arcserve identify which data blocks changed after the last backup.

&#x20;  - Used mainly for: Incremental backups

&#x20;  - this file will be in drive that si going to be backed up( let say c drive)

&#x20;  2.How It Works and help

&#x20;  --------------

&#x20;  a) Initial full backup is created.

&#x20;  b) ArcVolTrc.dat starts tracking changed blocks.

&#x20;  c) During incremental backup:

&#x20;     • Only modified data blocks are backed up

&#x20;     • Unchanged blocks are skipped





4\.**Standard Backup vs Advanced Backup**

**==================================**



1\. Standard Backup

&#x20;  ----------------

&#x20;  - Basic backup method used for normal data protection.

&#x20;  - Focuses mainly on backup and restore operations.

&#x20;  - store data and metadata in single file called d2d in destination

2\. Advanced Backup

&#x20;  ----------------

&#x20;  - Enhanced backup solution with additional protection and recovery features.

&#x20;  - Designed for enterprise or critical systems.

&#x20;  -store matadata in d2d file and actual data in "data" folder in chunks





**5. copy recovery points- tought around 1:05:00  in details**



**6.mount recovery points- tought around 1:16:00 in details**

**7.merge backups- tought around 1:17:00 to 1:27:00 in details**

&#x20; **-** merge will only  happen between custom backup files not daily backup files 

