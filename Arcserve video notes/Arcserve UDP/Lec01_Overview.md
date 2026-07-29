**1.) Arcserve UDP  have 3 parts**

a) Agents

b) COnsole

c)RPS Server



**2). 1. Arcserve Unified Data Protection Agent overview**

&#x20;  Explanation: Main agent responsible for backup and protection operations.



&#x20;  2 Core of the Protection System

&#x20;      Explanation: Central component of the data protection architecture.



&#x20;      2.1 Can be used to protect a standalone server

&#x20;            Explanation: Supports protection for an individual server.



&#x20;      2.1 Can be installed on a server to act as a proxy

&#x20;            Explanation: Can operate as a proxy server for backup activities.



&#x20;  3. Listens on Port 8014 (default port)

&#x20;      Explanation: Uses port 8014 as the default communication port.



&#x20;  4. Has its own interface (Tomcat.exe)

&#x20;      Explanation: Uses Tomcat.exe to provide its management interface.



&#x20;  5. Backups Controlled by AFBackend.exe

&#x20;      Explanation: Backup operations are managed by the AFBackend executable.



&#x20;  6. Infinite Incremental(s)

&#x20;      Explanation: Supports continuous incremental backups after the one full backup.



&#x20;      6.1 Change Block Tracking Driver → AFFLT.sys

&#x20;            Explanation: Tracks changed disk blocks for efficient incremental backups.



&#x20;  7. Destination:

&#x20;      Explanation: Specifies locations where backup data can be stored.



&#x20;      7.1 Shared folder

&#x20;            Explanation: Backup destination can be a shared network folder.



&#x20;      8.2 Local Folder (If the folder is local to the machine being backed up, the drive which holds the backup will be skipped during backup)

&#x20;            Explanation: Local storage is supported, but the backup drive itself is excluded from backup operations.



&#x20;      9.3 Technology used for snapshot: Microsoft Volume Shadow Copy

&#x20;            Explanation: Uses Microsoft VSS technology for snapshot creation during backups.





3\)**Arcserve Unified Data Protection Agent - Restore Methods:**

&#x20;  Explanation: Different methods available for restoring backup data.



&#x20;  1 UDP View (controlled by Arcserve UDP Agent Explorer Extension Service)

&#x20;      Explanation: Provides a view interface managed by the Agent Explorer Extension Service.



&#x20;  2 Mount Recovery Point (AFMntDrvInstall.exe)

&#x20;      Explanation: Allows mounting of recovery points using the AFMntDrvInstall executable.

&#x20;          -Mounting a recovery point means attaching a backup image or snapshot to the system so it behaves like a normal disk drive or folder.

&#x20;           eg. a)Suppose a server backup was taken yesterday.

&#x20;               b)Instead of restoring the whole server, the recovery point is “mounted.”

&#x20;               c)It may appear as a new drive like E: or F: in Windows.

&#x20;               d)Then you can directly access old files from that backup.



&#x20;  3 List all mounted volume(s) in current system:

&#x20;      Explanation: Displays all recovery volumes currently mounted in the system.

&#x09;	    Recovery volume- When a backup is mounted, the backup data appears as a virtual disk/volume in the operating system. That virtual disk is called a recovery volume.



&#x20;      3.1 AFMntDrvInstall.exe -list

&#x20;            Explanation: Command used to list all mounted recovery volumes.



&#x20;  4 Find Files and Folders to Restore (CatalogGenerator.exe)

&#x20;      Explanation: Helps search and restore specific files and folders in backups data.



&#x20;  5 Exchange GRT (GRT Tool)

&#x20;      Explanation: Granular Restore Technology tool for restoring Exchange data. here exchange data are emails, contacts etc.



&#x20;  6 Active Directory Restore

&#x20;      Explanation: Supports restoration of Active Directory objects and services.





**4.Arcserve Unified Data Protection Console**

&#x20;  Explanation: Central management console used to control and monitor Arcserve UDP operations--means all agents ka kaam ek hi jagah se dekhna and monitor karna.



&#x20;  2.1 Arcserve UDP Management Service (Tomcat)

&#x20;      Explanation: Management service running on Apache Tomcat for handling UDP console operations.



&#x20;  2.2 Listens on Port 8015 (Default)

&#x20;      Explanation: Uses port 8015 as the default communication port for the management service.



&#x20;  2.3 Arcserve UDP Management Port Sharing Service (Apache/2.4.34 (Win32) OpenSSL/1.0.2p)

&#x20;      Explanation: Apache-based service responsible for port sharing and secure communication using OpenSSL.



&#x20;  2.4 Arcserve UDP Identity Service (WS02)

&#x20;      Explanation: Service responsible for authentication and identity-related operations.



3\. Backend Database

&#x20;  Explanation: Database section used to store configuration and management data of UDP Console.



&#x20;  3.1 SQL Server Express

&#x20;      Explanation: Microsoft SQL Server Express edition used as the backend database.



&#x20;  3.2 Instance Name: ARCSERVE\_APP

&#x20;      Explanation: Name of the SQL Server database instance used by Arcserve UDP.



4\. Role Based Access Control (Port 8012)

&#x20;  Explanation: Security mechanism that controls user permissions and access roles using port 8012.-means who can do backup who cant



5\. Common Modules for Tomcat and Apache

&#x20;  Explanation: Shared modules/components used by both Tomcat and Apache services.







**5.Recovery Point Server**

&#x20;  Explanation: Server component responsible for storing and managing backup recovery points.



&#x20;  1 Arcserve UDP RPS Data Store Service

&#x20;      Explanation: Service responsible for managing backup datastore operations to the datastore. each backup can go to the one datastore only or many backup can go to the one datastore..



&#x20;  2 Arcserve UDP RPS Port Sharing Service

&#x20;      Explanation: Service used for handling shared communication ports in the RPS environment.



&#x20;  3 Non-Dedupe Datastore

&#x20;      Explanation: Datastore type where backup data is stored without deduplication.



&#x20;  4 Dedupe Datastore (Global Dedupe / Client Side Dedupe)

&#x20;      Explanation: Datastore that removes duplicate backup data to save storage space.



&#x20;      4.1 GDDClient

&#x20;            Explanation: Client-side deduplication component responsible for reducing duplicate data before transfer.



&#x20;      4.2 GDDServer

&#x20;            Explanation: Server-side deduplication component responsible for managing global deduplication.



&#x20;  5 Recovery Point Server is like a place holder where Datastore can be created

&#x20;      Explanation: RPS acts as the hosting platform where backup datastores are configured and maintained.



&#x20;  6 The Backup Destination will be the Datastore

&#x20;      Explanation: Backup data is stored directly inside the configured datastore.



&#x20;  7 Each Backup to a Datastore will be written to a Recovery Point inside the Datastore

&#x20;      Explanation: Every backup operation creates a recovery point stored within the datastore.



&#x20;  8 Datastore Ports: 5001 – 5090

&#x20;      Explanation: Port range used for datastore communication and operations.



&#x20;  9 RPS Server cannot be installed without the agent component

&#x20;      Explanation: The Recovery Point Server requires the Arcserve agent component for installation and operation.









**6.Agentless Backup for VMs in Hypervisor**

&#x20;  --------------------------------------

&#x20;  - Backup of  all Virtual Machines (VMs) without installing agents inside each VM.

&#x20;  - Backup is managed directly through the hypervisor layer.

\-we need to install the agent on one server that can be the vm(vm server) or physical server outside the hypervisor. and that server is called peroxy.



2\. Supported Hypervisors

&#x20;  ----------------------

&#x20;  a) Hyper-V

&#x20;     - Microsoft virtualization platform for running VMs.



&#x20;  b) VMware

&#x20;     - Widely used enterprise virtualization solution.



&#x20;  c) Nutanix AHV

&#x20;     - Nutanix Acropolis Hypervisor for virtual infrastructure management.



3\. Pre-Requisites

&#x20;  ----------------

&#x20;  a) Proxy Server Required

&#x20;     - A proxy server is needed to install and manage the UDP Agent.



&#x20;  b) Proxy Server Location

&#x20;     - Can be:

&#x20;       • One of the VMs inside the hypervisor

&#x20;       • Any other server with a supported Operating System (OS)



4\.➤ Doesn't use AFFLT.sys for tracking changes



&#x20; ➤ Instead of AFFLT.sys, UDP uses different approach for different Hypervisors



&#x20;  ➤ For VMware, UDP uses VMware Change Block Tracking (CBT) drivers to track changes



&#x20;  ➤ For Hyper-V, for Windows 2012 and earlier versions of Hypervisor, UDP had its own CBT (XOMFCBT)



&#x20;   ✓ From Windows 2016, UDP uses Hyper-V Resilient Change Tracking Driver



&#x20;  ➤ For Nutanix, we compare snapshots (old one vs new one) to track the changes



**7.Microsoft Office 365 Backups**

&#x20;  -----------------------------

&#x20;  - Arcserve UDP provides backup and protection for Microsoft Office 365 applications.

&#x20;  - Helps in securing cloud-based user data and files.



2\. Applications Protected in Office 365 Family

&#x20;  --------------------------------------------



&#x20;  a) Exchange Online

&#x20;     - Cloud-based email and calendar service by Microsoft.

&#x20;     - Protects emails, contacts, and mailbox data.



&#x20;  b) SharePoint Online

&#x20;     - Web-based collaboration and document management platform.

&#x20;     - Protects shared documents, team sites, and project data.



&#x20;  c) OneDrive

&#x20;     - Microsoft cloud storage service for personal and business files.

&#x20;     - Protects uploaded files and folders from accidental loss.



3\. Key Benefit

&#x20;  -------------

&#x20;  - Centralized backup and recovery for Office 365 services.

&#x20;  - Ensures business data safety and easy restoration.





**8.) Virtual Standby**

===============



1\. Definition

&#x20;  ------------

&#x20;  - Virtual Standby creates a ready-to-run virtual machine (VM)

&#x20;    from backup data.

&#x20;  - It helps quickly recover systems during server failure or disaster.



2\. How It Works

&#x20;  --------------

&#x20;  a) Backup of physical/virtual machine is taken.

&#x20;  b) Backup data is converted into a VM format.

&#x20;  c) VM is kept updated automatically after each backup.

&#x20;  d) If the main server fails, the standby VM can be powered ON instantly.







**9. Virtual Standby Pre-requisites**

&#x20;  --------------------------------

&#x20;  - Requirements needed before creating a Virtual Standby (VSB) machine.



2\. Valid Recovery Point Required

&#x20;  ------------------------------

&#x20;  - You must have a valid recovery point to create a virtual standby machine.

&#x20;  - Recovery points can come from the following tasks:



&#x20;  a) Backup, Agent-based Windows

&#x20;     - Backup created using an installed Windows backup agent.



&#x20;  b) Backup, Host-Based Agentless

&#x20;     - Backup performed through the host/hypervisor without installing agents.



&#x20;  c) Replication

&#x20;     - Data copied continuously from one system to another for recovery purposes.



&#x20;  d) Replication from a remote Recovery Point Server

&#x20;     - Recovery data replicated from a remote backup/recovery server.



3\. Full Machine Backup Requirement

&#x20;  --------------------------------

&#x20;  - Full machine backup is necessary to enable the Virtual Standby task.

&#x20;  - Virtual Standby cannot be created using partial backups.



4\. Permission Verification

&#x20;  ------------------------

&#x20;  - Verify that minimum permissions are available for performing VSB tasks.

&#x20;  - Proper access rights are required for backup and recovery operations.



5\. Compatibility Matrix Review

&#x20;  ----------------------------

&#x20;  - Check the Compatibility Matrix for supported:

&#x20;    • Operating Systems

&#x20;    • Databases

&#x20;    • Browsers



6\. Key Benefit

&#x20;  -------------

&#x20;  - Helps ensure quick disaster recovery using virtual standby machines.

&#x20;  - Maintains system readiness in case of failures.







**10. Instant Virtual Machine**

&#x20;  ------------------------

&#x20;  - Arcserve UDP allows creation of a virtual machine directly from a recovery point.

&#x20;  - Provides immediate access to backed-up data and applications.

&#x20;  - Reduces downtime compared to traditional restore methods.



2\. Purpose of Instant Virtual Machine

&#x20;  -----------------------------------

&#x20;  - Eliminates delay caused by:

&#x20;    • Traditional restore process

&#x20;    • Conversion of backup session into a physical or virtual machine



3\. xoiv8x64.sys

&#x20;  --------------

&#x20;  - Driver that redirects read I/O operations from the virtual disk to the recovery point.

&#x20;  - Helps the VM access backup data instantly.



4\. InstantVMAgent.exe

&#x20;  -------------------

&#x20;  - Connects to the communication kernel port created by the Instant VM driver.

&#x20;  - Handles the following requests from the driver:

&#x20;    • READ

&#x20;    • CREATE

&#x20;    • CLOSE



5\. XOIV Driver Function

&#x20;  ---------------------

&#x20;  - XOIV driver redirects I/O requests to InstantVMAgent.exe.

&#x20;  - Enables communication between virtual disk operations and backup recovery data.



6\. Key Benefit

&#x20;  -------------

&#x20;  - Fast recovery and minimal downtime.

&#x20;  - Quick access to applications and backup data without full restoration.





**11.1. File Copy**

&#x20;  ----------

&#x20;  - Process of creating a duplicate of a file at another location.

&#x20;  - Original file remains unchanged after copying.

&#x20;  2. File Archive

&#x20;  --------------

&#x20;  - Process of storing files in a compressed or organized format for long-term storage.

&#x20;   - Original file deleted.

&#x20;  - Helps reduce storage space and manage old files efficiently.





**12. In last 10 minutes they have tought  to backup the files**



**13. after installing go to the "services" to find the list of instealled applcaition and software**



**14. from 1:34:00 to 1:38:00 we have learnt about the logs**

