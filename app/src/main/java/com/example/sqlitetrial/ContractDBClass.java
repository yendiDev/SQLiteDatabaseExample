package com.example.sqlitetrial;




public final class ContractDBClass {

    private ContractDBClass() {}

   public static class ContactEntry
    {

        public static final String TABLE_NAME = "contact_info";
        public static final String COLUMN_ID = "contact_id";
        public static final String COLUMN_NAME = "contact_name";
        public static final String COLUMN_EMAIL = "contact_email";

    }


}
