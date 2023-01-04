<?php

class DB
{
    private string $host = "Server-url";
    private string $dbName = "Schema-name";
    private string $usernameDB = "Username";
    private string $passwordDB = "Password";
    private static $db = null;
    private PDO $dbHandle;


    private function __construct()
    {
        try {
            $this->dbHandle = new PDO("mysql:host=$this->host;dbname=$this->dbName", $this->usernameDB, $this->passwordDB);
        } catch
        (PDOException $e) {
            echo $e->getMessage() . PHP_EOL;
            echo $e->getTraceAsString() . PHP_EOL;
            echo phpinfo();
        }
    }

    /**
     * Get the Database-connection.
     * If no database-connection exists for this session, a new one will be created.
     */
    public static function getDBConnection() {
        if (DB::$db==null) {
            DB::$db = new self();
        }
        return DB::$db->dbHandle;
    }

    /**
     * Close the Database-connection
     */
    public static function closeDBConnection(){
        if (DB::$db!=null){
            DB::$db = null;
        }
    }
}
