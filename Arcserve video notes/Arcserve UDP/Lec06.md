**1. Add a Data Store – Enable Deduplication**

**=======================================**



• While adding a data store, select the check box “Enable Deduplication” to enable Data Deduplication.



&#x20; - Crisp Explanation:

&#x20;   Deduplication can be enabled while creating a Data Store.



• Enable Deduplication



&#x20; ▪ Specifies whether to enable data deduplication.



&#x20;   - Crisp Explanation:

&#x20;     Controls whether duplicate data removal is active.



&#x20; ▪ arcserve UDP supports both types of deduplication:



&#x20;   - Crisp Explanation:

&#x20;     Arcserve UDP supports multiple deduplication methods.



&#x20;   ▪ Source-side deduplication and Global deduplication.



&#x20;     - Crisp Explanation:

&#x20;     Source-side deduplication

Deduplication happens on the source node itself during backup processing before data is transmitted to the RPS.

&#x20;Working:

&#x20;  • UDP Agent identifies duplicate data blocks locally.

&#x20;  • Only unique blocks are transferred over network.

Global Deduplication

&#x20;   - Deduplication performed across all client machines/nodes in the RPS Data Store.



&#x20;  Working:

&#x20;  • RPS compares backup blocks from multiple machines.

&#x20;  • Only one copy of identical blocks is stored.

&#x20;  



**2.Add a Data Store – Enable Deduplication**

**=======================================**

• Data Destination

&#x20; ▪ Defines the data destination folder to save the actual unique data blocks. Use the largest disk to store data as that contains the original data blocks of source.

&#x20;   - Crisp Explanation:

&#x20;     Stores actual unique backup blocks after deduplication.

&#x20; ▪ Note: The Data Destination path should be a blank folder.

&#x20;   - Crisp Explanation:

&#x20;     The destination folder must be empty before configuration.

• Index Destination

&#x20; ▪ Defines the index destination folder to store the index files. Choose a different disk to improve the deduplication processing.

&#x20;   - Crisp Explanation:

&#x20;     Stores deduplication index/metadata files separately for better performance.

&#x20; ▪ Note: The Index Destination path should be a blank folder.

&#x20;   - Crisp Explanation:

&#x20;     The index folder must also be empty before setup.







**3. Add a Data Store – Enable Deduplication**

**=======================================**



• Hash Destination

&#x20; ▪ Defines the path to store the hash database. Selecting a high speed Solid State Drive (SSD) can increase the deduplication capacity with a low memory allocation required.

&#x20;   - Crisp Explanation:

&#x20;     Stores hash database used for deduplication processing. SSD improves performance.

&#x20; ▪ Note: The Hash Destination path should be a blank folder.

&#x20;   - Crisp Explanation:

&#x20;     Hash destination folder must be empty before setup.



• Hash Destination is on a Solid State Drive (SSD)

&#x20; ▪ Specifies if the hash folder is on a solid state drive.

&#x20;   - Crisp Explanation:

&#x20;     Indicates whether hash storage uses SSD for faster processing.

&#x20; ▪ Hash destination is on a Solid State Drive(SSD)

• Memory Allocation

&#x20; ▪ Specifies the amount of physical memory that you allocate to keep hashes.

&#x20;   - Crisp Explanation:

&#x20;     Defines RAM allocation used for storing hash information during deduplication.





**4.Add a Data Store – Enable Deduplication**

**=======================================**



• Deduplication Block Size



&#x20; ▪ Defines the deduplication block size. The options are 4 KB, 8 KB, 16 KB, 32 KB, and 64 KB. The deduplication block size also impacts the Deduplication capacity estimation. If you change the default 4KB, for example, to 8KB, the Deduplication capacity estimations double. Increasing the deduplication block size can decrease the deduplication percentage.



&#x20;   - Crisp Explanation:

&#x20;     Block size affects deduplication efficiency, storage estimation, and performance.



&#x20; ▪ Note: You cannot specify the same path for the following four folders: Backup Destination folder, Data Destination, Index Destination, and Hash Destination.



&#x20;   - Crisp Explanation:

&#x20;     All destination folders must use separate paths.



• (Optional) Set values for the Estimate Memory and Storage Requirements options. These options help to estimate the capacity of a Deduplication data store.



&#x20; - Crisp Explanation:

&#x20;   Used to estimate memory and storage requirements for deduplication.



• Also provide other information such as Data Store Name, Backup Destination folder, Compression Type, Concurrent Active Nodes, Encrypt Data. (We discussed these options during the Non-Dedupe Data Store session.)



&#x20; - Crisp Explanation:

&#x20;   Additional datastore configuration settings are required during setup.



• After specifying the values, click “Save” to create the Data Store with Data Deduplication.



&#x20; - Crisp Explanation:

&#x20;   Saves and creates the deduplicated data store configuration.







**5. two component of data deduplication- GDD client, GDD  server**

&#x20;  

&#x20; *1.Data Deduplication - GDD Client*

*===============================*



• It is deployed on Arcserve UDP Agent Node.



&#x20; - Crisp Explanation:

&#x20;   GDDClient runs on the source machine/node where backup starts.



• During backup,



&#x20; ▪ GDDClient will divide file data stream into the fixed-size blocks. (4k, 8k – Based on Dedupe Block Size)



&#x20;   - Crisp Explanation:

&#x20;     Backup data is split into fixed-size blocks for deduplication.



&#x20; ▪ GDDClient then calculate hashes. GDDClient will send the hashes to GDDServer Hash Role for comparison.



&#x20;   - Crisp Explanation:

&#x20;     Hash values are generated and compared to identify duplicate blocks.



&#x20; ▪ Finally, GDDClient only sends unique data blocks to GDDServer.



&#x20;   - Crisp Explanation:

&#x20;     Only non-duplicate data is transferred to save bandwidth and storage.



• GDDClient supports both 32-bit platform and 64-bit platform.



&#x20; - Crisp Explanation:

&#x20;   GDDClient works on both 32-bit and 64-bit systems.



2\. GDD Server

==========



• This component is on the RPS Server, the name of the process is GDDServer.exe



&#x20; - Crisp Explanation:

&#x20;   GDDServer.exe runs on the RPS server for deduplication processing.



• The RPS Dedupe system divides the whole server functionality into 3 different roles – Index Role, Hash Role and Data Role. Each role takes its own responsibility independently.



&#x20; - Crisp Explanation:

&#x20;   Deduplication tasks are separated into independent processing roles.



• Index Role – It is responsible for managing global metadata files such as Index and Reference files. It also manages the mapping table for hashes and data blocks.



&#x20; - Crisp Explanation:

&#x20;   Handles metadata and maintains mapping information for hashes and blocks.



• Hash Role – It is responsible for hash calculation. It provides hash searching/inserting/deleting and other functionalities.



&#x20; - Crisp Explanation:

&#x20;   Performs hash operations used to identify duplicate data blocks.



• Data Role – It is responsible for managing and writing unique data blocks.



&#x20; - Crisp Explanation:

&#x20;   Stores and manages only unique deduplicated backup data.



• For every Dedupe Data Store which is started, it would have three GDDServer.exe processes running. One process for each role.



&#x20; - Crisp Explanation:

&#x20;   Separate GDDServer.exe process runs for Index, Hash, and Data roles.







**6. Data Deduplication Workflow In Steps**

**===================================**



The workflow of one backup job is as the below.



○ Step 1 - Split data to blocks and calculate hashes (Block size will be configurable);



○ Step 2 - Implement pre-hash algorithm to map the hashes to different hash ranges;



○ Step 3 - Group the hashes based on the hash range and cache them in memory (The memory size to cache hashes will be configurable);



○ Step 4 - Cache the data blocks in memory (the memory size to cache data blocks will be configurable);



○ Step 5 - Once the hashes in one range hit some criteria (configurable), connect to the specific GDD hash member server and send the hashes to the server for searching/comparing;



○ Step 6 - For duplicated hashes, get ref file number and offset from GDD hash member server and create index entry.



○ Step 7 - For unique hashes, send data to a GDD data member server to store data, and create ref entry and index entry.



○ Step 8 - Communicate with GDD primary server to update index/ref file.



○ Step 9 - Communicate with these specific GDD hash member servers to insert the new hashes to hash table in memory.









**7. Data Deduplication / Dedupe Data Store Files Detailed**



Dedupe Data Store Files - Detailed



○ Index File – This file has information about the Ref files. (Ex: G\_0000000001.index)

&#x20; The index file contains the offset info to the corresponding ref entries of every 4KB block. One

&#x20; index entry is made up of the following,

&#x20;   ▪ the file number of ref file

&#x20;   ▪ offset of ref entry in the specific ref file.



○ Ref File – The ref file contains the offset info to the corresponding data blocks and the hash key.

&#x20; Ex: G0000000001.ref



○ Data File – This file contains the unique blocks.

&#x20; Ex: G0000000001\_P000000.data, G0000000001\_P000001.data



○ Hash DB – Hash entries will be separately managed and stored by hash service of GDD. The Hash DB

&#x20; contains the unique hash keys. It is used for hash comparing to find out duplicated blocks during

&#x20; backup. One hash entry is made up of the following,



&#x20;   ▪ hash key of the data block (SHA1).



&#x20;   ▪ file number of ref file.



&#x20;   ▪ offset of ref entry in the specific ref file.



&#x20;   ▪ reference count (Reference count means how many index entries are referring to a data block.)







