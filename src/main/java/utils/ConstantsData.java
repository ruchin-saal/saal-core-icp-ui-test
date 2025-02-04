package utils;

public class ConstantsData {
    // Application
    public static final String LOGIN_WELCOME = "Welcome Back!";
    public static final String ENTER_YOUR_CREDENTIALS_MESSAGE = "Please provide your credentials to securely access your account.";
    public static final String LOGIN_ERROR_MSG = "Invalid username or password.";
    public static final String ADMIN_WELCOME_MESSAGE = "Welcome automation admin";
    public static final String SCIENCETIST_WELCOME_MESSAGE = "Welcome automation sciencetist";
    public static final String ENGINEER_WELCOME_MESSAGE = "Welcome automation engineer";
    public static final String ANALYST_WELCOME_MESSAGE = "Welcome automation analyst";
    //Policy Management
    public static final String POLICY_MANAGEMENT_LNK = "Policies";
    public static final String POLICY_MANAGEMENT_LBL = "Policy Management";
    public static final String CREATE_POLICY_BUTTON_LBL = "Policy";
    public static final String SYNC_LBL = "Sync";
    public static final String Priority_LBL = "Priority";
    public static final String ID_LBL = "Id";
    public static final String NAME_LBL = "Name";
    public static final String CATEGORY_LBL = "Category";
    public static final String CATEGORY_MANDATORY_LBL = "Category*";
    public static final String CATALOG_LBL = "Catalog";
    public static final String SCHEMA_LBL = "Schema";
    public static final String TABLES_LBL = "Tables";
    public static final String GROUPS_LBL = "Groups";
    public static final String USERS_LBL = "Users";
    public static final String STATUS_LBL = "Status";
    public static final String SYNC_STATUS_LBL = "Sync Status";
    public static final String ACTION_LBL = "Actions";
    public static final String POLICY_MANAGEMENT_HEADER_LBL = "Policy Management";
    //create new policy
    public static final String CREATE_NEW_POLICY_LBL = "Policy Details";
    public static final String POLICY_NAME_LBL = "Name";
    public static final String POLICY_DETAILS_LBL = "Policy Details";
    public static final String NEXT_LBL ="Next";
    public static final String CATALOG_EDIT ="Catalog Edit";
    public static final String USERS_NAME = "admin";
    public static final String USERS_NAME_2 = "testinguser2";
    public static final String GROUP_NAME = "bigdata-admin";
    public static final String CATALOG ="Catalog";
    public static final String SCHEMA ="Schema";
    public static final String TABLE ="Tables";
    public static final String TABLE_CATEGORY_VALIDATION ="tables";
    public static final String CATEGORY_CATALOG ="Catalog";
    public static final String CATEGORY_SCHEMA ="Schema";
    public static final String CATEGORY_TABLE ="Tables";
    public static final String CATALOG_POLICY_NAME ="AutomationCatalogPolicy";
    public static final String SCHEMA_POLICY_NAME ="AutomationSchemaPolicy";
    public static final String TABLE_POLICY_NAME ="AutomationTablePolicy";

    public static final String EDIT_CATALOG_POLICY_NAME ="AutomationEditCatalogPolicy";
    public static final String EDIT_SCHEMA_POLICY_NAME ="AutomationEditSchemaPolicy";
    public static final String EDIT_TABLE_POLICY_NAME ="AutomationEditTablePolicy";
    public static final String POLICY_NAME ="Automation";
    public static final String NO_RECORDS_FOUND_LBL ="No records found";
    public static final String CATALOG_2 ="datalake";
    public static final String CATALOG_1 ="datawarehouse";
    public static final String SCHEMA_NAME_FOR_SELECTION ="world_data_bank_raw";
    public static final String CATALOG_NAME_WITH_CATALOG_TEXT ="Catalog: "+ CATALOG_2;
    public static final String SCHEMA_NAME ="test_schema";
    public static final String TABLE_NAME ="test_employee";
    public static final String TABLE_NAME_2 ="test_emp_temp";
    public static final String MASK_COLUMN_NAME ="employee_phone";
    public static final String MASK_TYPE ="Predefined";
    public static final String MASK_CATEGORY ="Partial Mask: Show Last 4";
    public static final String ROW_FILTER_COLUMN_NAME ="employee_name";
    public static final String ROW_FILTER_CONDITION ="LIKE";
    public static final String ROW_FILTER_VALUE ="J";
    public static final String POLICY_STATUS_SYNCED_LBL = "Synced";
    public static final String POLICY_STATUS_READY_TO_SYNCED_LBL = "Ready To Sync";
    public static final String DELETE_POLICY_ACTION ="Delete";
    public static final String EDIT_POLICY_ACTION ="Edit";
    public static final String CLONE_TABLE_POLICY ="TestTablePolicy(cloned)";
    public static final String ENABLE_POLICY_STATUS ="Enabled";
    public static final String DISABLE_POLICY_STATUS ="Disabled";
    public static final String EDITED_CATALOG_POLICY_NAME ="EditedCatalogPolicyAutomation";
    public static final String POLICY_DISABLED_TEXT="Access Denied";
    //Querybook Page Items
    public static final String DISCOVERY_HUB_LBL = "Discovery Hub";
    public static final String TABLE_NAME_FOR_SELECTION ="world_development_country_metadata";
    public static final String QUERY_COLUMN_NAME="employee_id";
    public static final String QUERY_COLUMN_VALUE="1";
    public static final String QUERY_LIMIT_VALUE="10";
    public static final String EMPLOYEE_PHONE_COLUMN_VALUE="XXXX4567";
    public static final String EMPLOYEE_NAME_COLUMN_VALUE="John Jordan";
    //Components Page Items
    public static final String TRINO_PAGE_LBL = "CLUSTER OVERVIEW";
    public static final String SPARK_PAGE_LBL = "Event log directory:";
    public static final String AIRFLOW_PAGE_LBL = "DAGs";
    public static final String MINIO_PAGE_LBL = "Object Browser";
    public static final String SUPERSET_PAGE_LBL = "Home";
    public static final String DEBEZIUM_PAGE_LBL = "Create Connector";
    public static final String JUPYTERHUB_PAGE_LBL = "Notebook";
    public static final String KAFKA_PAGE_LBL = "Kafka Hub";
    public static final String KEYCLOAK_PAGE_LBL = "Welcome to Keycloak";
    public static final String OPENSEARCH_WELCOME_MESSAGE_LBL = "Welcome to OpenSearch Dashboards";
    public static final String PINOT_PAGE_LBL = "Home";
    public static final String NIFI_PAGE_LBL = "Nifi Flow";
    public static final String ARROW_PAGE_LBL = "Client Configuration";
    public static final String FLINK_PAGE_LBL = "Apache Flink Dashboard";
    public static final String FLINK_JOBS_PAGE_LBL = "CPU Cores";
    //Audits Page Items
    public static final String ACCESS_CONTROL_PAGE_LBL_1 = "Components";
    public static final String ACCESS_CONTROL_PAGE_LBL_2 = "Menu";
    public static final String AUDIT_AIRFLOW_PAGE_LBL = "Dag Runs";
    public static final String CLASSIFICATION_PAGE_LBL = "Data Classification";
    public static final String DISCOVERY_HUB_PAGE_LBL = "Discovery Hub";
    public static final String POLICIES_PAGE_LBL = "Policies";
    public static final String AUDIT_TRINO_PAGE_LBL = "Trino";
    public static final String USERS_ADMIN_LBL = "Admin Events";
    public static final String USERS_LOGIN_LBL = "Login Events";
    public static final String USERS_SYNC_LBL = "Sync Events";
    public static final String USERS_PAGE_LBL_1 = "User Management";
    public static final String USERS_PAGE_LBL_2 = "Users";
    public static final String USERS_PAGE_LBL_3 = "Groups";
    public static final String INSIGHTS_PAGE_LBL_1 = "Insights";
    public static final String INSIGHTS_PAGE_LBL_2 = "Usage Summary";
    public static final String INSIGHTS_PAGE_LBL_3 = "Pipeline Summary";
    public static final String INSIGHTS_PAGE_LBL_4 = "Data Summary";

    public static final String HOME_PAGE_LBL_1 = "Usage Summary";
    public static final String HOME_PAGE_LBL_3 = "Cluster";
    public static final String HOME_PAGE_LBL_4 = "Resource Utilization";

    //Setting Page Items
    public static final String SETTING_PAGE_LBL = "Insights Preference";
    public static final String LICENSES_PAGE_LBL = "Manage Licenses";
    public static final String MENU_PAGE_LBL = "Manage Menu Permissions";
    public static final String COMPONENTS_PAGE_LBL = "Manage Component Permissions";

}
