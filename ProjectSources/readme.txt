Installation-instructions for project "Hot Ostrich"

System requirements:
    OS: any (Linux-based preffered)
    MySQL Server version: 10.2.32-MariaDB-log
    PHP Version: 7.4.6
    
    Earlier/other versions may work, but is untested.
    Do so at your own risk!
    


Installation - Easy-mode:

    Supply this zip-file to your (competent) sysadmin.
    (S)He should be able to figure it out within 15min.
    If (s)he doesn't, it's time to hire a new sys-admin.
    
    
    
Installation - Hard-mode:


    Database-creation:
        
        1)  Open a SQL-Editor, such as MySQL-Workbench, and establish a connection to the desired schema on your MySQL-server.
        
        2a) Open the supplied sql-script 'hot_ostrich_db_final.sql' in the 'database' folder and execute it (Recommended).
            The neccessary tables will be created and filled with the minimally required data.
            There will be a default administrator-user whom have access to _everything_
            Username: Administrator
            Password: test1234
        
        2b) ADVANCED USERS ONLY! This approach assumes you have intimate knowledge with managing SQL-databases by hand.
            Open the database-schema 'hot_ostrich_db_final.mwb' in the 'database' folder and supply the minimal ammount of required
            data before (or after, your choice....) forward-engineering to your sql-server.
            Tables of interest are: 'Degree,' 'ExamType,' 'GradeScale,' 'InboxType,' 'Language,' 'Position,' 'Role,' 'StudyPoints'.
            Additionally, a user must be registered, and manually set to be an administrator afterwards.
            
            
    Website-installation
        
        1) Unzip and move the contents of the 'website' folder into the desired root-folder on your webserver.
           This is usually the 'htdocs'-folder for your apache2 server with PHP 7.4.6, XAMPP-install, or LAMP-stack installation.
           
        2) Change the credentials in 'website/php/classes/DB.class.php' to match with your credentials for your SQL-server.
        
        3) Configure your DNS/Server to point to the relevant domain/folder, respectivly.
