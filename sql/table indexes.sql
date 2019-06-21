-- Partial indexes defined by a condition: Case RecordType = 'Field Service'
CREATE INDEX cplan_case_createddate ON salesforce.case(createddate DESC) WHERE recordtypeid = '012w0000000V9MrAAK';
CREATE INDEX cplan_case_status ON salesforce.case(status) WHERE recordtypeid = '012w0000000V9MrAAK' AND status IS NOT NULL;

-- Indexes for join tables
CREATE INDEX cplan_asset_main_work_center__c ON salesforce.asset(main_work_center__c);
CREATE INDEX cplan_asset_accountid ON salesforce.asset(accountid);
CREATE INDEX cplan_workorder_caseid ON salesforce.workorder(caseid);
CREATE INDEX cplan_serviceappointment_work_order__c ON salesforce.serviceappointment(work_order__c);
CREATE INDEX cplan_serviceterritorymember_serviceresourceid ON salesforce.serviceterritorymember(serviceresourceid);

-- B-tree indexes for filter fields
CREATE INDEX cplan_asset_installation_country__c ON salesforce.asset(installation_country__c) WHERE installation_country__c IS NOT NULL;
CREATE INDEX cplan_asset_equipment_type__c ON salesforce.asset(equipment_type__c);
CREATE INDEX cplan_asset_fsm_last_valid_cli_end_date__c ON salesforce.asset(fsm_last_valid_cli_end_date__c) WHERE fsm_last_valid_cli_end_date__c IS NOT NULL;
CREATE INDEX cplan_account_sales_organizations__c ON salesforce.account(sales_organizations__c) WHERE sales_organizations__c IS NOT NULL;

-- GIN indexes for filter fields
CREATE EXTENSION pg_trgm;
CREATE INDEX cplan_search_idx_asset_name ON salesforce.asset USING GIN (name gin_trgm_ops);
CREATE INDEX cplan_search_idx_asset_customer_asset_name__c ON salesforce.asset USING GIN (customer_asset_name__c gin_trgm_ops);
CREATE INDEX cplan_search_idx_asset_equipment_phone_number__c ON salesforce.asset USING GIN (equipment_phone_number__c gin_trgm_ops);
CREATE INDEX cplan_search_idx_asset_installation_street__c ON salesforce.asset USING GIN (installation_street__c gin_trgm_ops);
CREATE INDEX cplan_search_idx_asset_installation_city__c ON salesforce.asset USING GIN (installation_city__c gin_trgm_ops);
CREATE INDEX cplan_search_idx_asset_installation_state_provice__c ON salesforce.asset USING GIN (installation_state_provice__c gin_trgm_ops);
CREATE INDEX cplan_search_idx_account_name ON salesforce.account USING GIN (name gin_trgm_ops);
CREATE INDEX cplan_search_idx_account_sales_organizations__c ON salesforce.account USING GIN (sales_organizations__c gin_trgm_ops);
CREATE INDEX cplan_search_idx_location_name ON salesforce.location USING GIN (name gin_trgm_ops);