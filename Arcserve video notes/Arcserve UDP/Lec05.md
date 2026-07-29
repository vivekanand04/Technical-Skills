**1.Overview of RPS**

**===============**



• An RPS is a central destination where you can store data from multiple recovery points and can recover them if necessary. While creating a backup plan to protect nodes, you can specify this RPS for multiple source nodes.



&#x20; - Crisp Explanation:

&#x20;   RPS acts as a centralized backup storage server for multiple machines.



• RPS would offload resource-intensive tasks from the arcserve UDP Agent (Windows), such as catalog generation and merge/purge operations.



&#x20; - Crisp Explanation:

&#x20;   RPS reduces workload on source systems by handling heavy backup operations.



• RPS can be used as a local storage center and also as a replication engine for multi-site data protection to remote locations (taking advantage of global source-side data deduplication functionality).



&#x20; - Crisp Explanation:

&#x20;   RPS supports centralized storage, replication, and deduplication for efficient backup management.





**2. Overview of RPS**

**===============**



• You can build multiple storage targets (Data Stores) on a Recovery Point Server.



&#x20; - Crisp Explanation:

&#x20;   Multiple backup storage repositories can be created inside one RPS.



• RPS provides Source Side Global Data Deduplication.



&#x20; - Crisp Explanation:

&#x20;   Duplicate data blocks are removed before transfer to save storage and bandwidth.



• RPS is a backend component.



&#x20; - Crisp Explanation:

&#x20;   RPS works in the background for storage and backup processing.



• RPS Data Stores can be managed from arcserve UDP Server/Console



&#x20; - Crisp Explanation:

&#x20;   Data stores are centrally managed through the UDP Console.



• arcserve UDP agent is a pre-requisite to install RPS.



&#x20; - Crisp Explanation:

&#x20;   UDP Agent must be installed before setting up the RPS.



Diagram Flow:

\-------------

UI → RPS → D2D Backups

&#x20;         → RPS1 → RPS2



&#x20; - Crisp Explanation:

&#x20;   Backup data flows from UI-managed RPS to multiple D2D stores and can replicate between RPS servers.







**3. Overview of Data Store**

**======================**



• Data Store is used by Recovery Point Servers as a location for storing backed-up data.



&#x20; - Crisp Explanation:

&#x20;   Data Store is the storage area where RPS keeps backup recovery points.



• The storage location can be a locally attached disk, remote shared folder, NAS device, iSCSI Target, SAN LUN.



&#x20; - Crisp Explanation:

&#x20;   Backups can be stored on local disks, network storage, or enterprise storage devices.



• Data Store provide plenty of options for data security and space efficient usage.



&#x20; - Crisp Explanation:

&#x20;   Data Store supports security and storage optimization features.



• Compression and global data deduplication are supported in data stores to help decrease the size of created backups.



&#x20; - Crisp Explanation:

&#x20;   Duplicate data is removed and backup size is reduced to save storage space.



• Encryption is also supported to provide security for the backed-up data.



&#x20; - Crisp Explanation:

&#x20;   Backup data can be encrypted for protection and secure access.





**4. we have learnt to create the data store, modify data store   and send data to data store from node etc.....**



**5. RPS Jump Start**

**==============**



• Using the RPS Jumpstart option you can copy data of nodes in a very short time from source to remote recovery point servers. Using other methods, setting up replication of data between two remote RPS server takes many days to complete, depending on the size of sources and bandwidth of the link.



&#x20; - Crisp Explanation:

&#x20;   RPS Jump Start quickly transfers initial backup data from source rps to remote RPS .



• You can use RPS Jumpstart after initial setup, when you add a node to the source RPS and want to replicate the data of that node to a remote recovery point server.



&#x20; - Crisp Explanation:

&#x20;   Used when a new node is added and its data must be replicated remotely.



• The RPS Jumpstart option lets you export data of nodes into portable storage, for example USB Drives, ship the media to remote location and import the data into target recovery point server. The process helps increase the speed of the process of replication, as well as reduces use of bandwidth.



&#x20; - Crisp Explanation:

&#x20;   Backup data can be physically transferred using portable storage to save network bandwidth.



• You can perform RPS Jumpstart first time for base synchronization and later also when a large new node with unique data is added to the source recovery point server.



&#x20; - Crisp Explanation:

&#x20;   Useful for first-time synchronization and large data additions.

• Common Scenario

&#x20;  ----------------

&#x20;  Source RPS → Export Data → USB/Portable Disk → Remote RPS → Import Data







6\. 



