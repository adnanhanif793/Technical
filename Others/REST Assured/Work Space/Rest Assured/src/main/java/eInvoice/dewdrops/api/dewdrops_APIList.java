package eInvoice.dewdrops.api;
/***
 * This class will contain all The API's of Dewdrops
 * @author ashiwani.ranjan
 *
 */

public final class dewdrops_APIList {
	
	public static final String filterAPI_Invoice="/einvoice/soa-services/restapi/invoice/filter";//EINVOICE-12147
	public static final String filterAPI_CreditMemo="/einvoice/soa-services/restapi/invoice/filter";//EINVOICE-12275
	public static final String Search_Attachement_Api="/einvoice/soa-services/restapi/attachment/filter";//EINVOICE-12277
	public static final String Get_Audittrail_Invoice_Api="/einvoice/soa-services/restapi/invoice/";//EINVOICE-12338
	public static final String Get_Audittrail_CreditMemo_Api="/einvoice/soa-services/restapi/creditMemo/";//EINVOICE-12356
	public static final String Get_Attachment_Api="/einvoice/soa-services/restapi/attachment/";//EINVOICE-12336
	public static final String searchRoleBasedUsers_Api="/einvoice/soa-services/restapi/user/filter/";//EINVOICE-12517
	public static final String searchUsers_Api="/einvoice/soa-services/restapi/user/filter";//EINVOICE-12518
	public static final String searchSupplier_Api="/einvoice/soa-services/restapi/supplier/filter";//EINVOICE-12278
    public static final String delegateWorkflow_Api="/einvoice/soa-services/restapi/workflowApproval/";//EINVOICE-12290
	public static final String remindworkflow_Api="/einvoice/soa-services/restapi/workflowApproval/";//EINVOICE-12290
    public static final String savedFilter_Api = "/einvoice/soa-services/restapi/invoice/filter/";//EINVOICE-12162
    public static final String FetchSavedFilters_Api = "/einvoice/soa-services/restapi/invoice/filter/getUserFilters/invoiceListing";//EINVOICE-12163
    public static final String CreateFilter_Api = "/einvoice/soa-services/restapi/invoice/filter/create";//EINVOICE-12166
 	public static final String Update_Filter_Api="/einvoice/soa-services/restapi/invoice/filter/update";//EINVOICE-12167
 	public static final String Delete_Filter_Api="/einvoice/soa-services/restapi/invoice/filter/";//EINVOICE-12228
 	public static final String Delete_Info_Api="/einvoice/soa-services/restapi/invoice/filter/deleteWithInfo";//EINVOICE-12229
 	public static final String mailbox_search="/einvoice/soa-services/restapi/invoice/mailbox/filter";//EINVOICE-12409
	public static final String ApproveWorkflowApproval = "/einvoice/soa-services/restapi/workflowApproval/";//EINVOICE-12880
	public static final String RejectWorkflowApproval = "/einvoice/soa-services/restapi/workflowApproval/";//EINVOICE-12886
	public static final String Search_Approval="/einvoice/soa-services/restapi/workflowApproval/filter/";//EINVOICE-12305
	public static final String getProcessEform = "/einvoice/soa-services/restapi/processEForm/";//EINVOICE-12339
	public static final String getProcessEformBasic = "/einvoice/soa-services/restapi/processEForm/";//EINVOICE-12425
	public static final String createProcessEform = "/einvoice/soa-services/restapi/processEForm/create";//EINVOICE-12340
	public static final String updateProcessEform = "/einvoice/soa-services/restapi/processEForm/update";//EINVOICE-12341
	public static final String getSupplierPaymentTerm = "/einvoice/soa-services/restapi/supplier";//EINVOICE-12341
	public static final String getPOListing = "/einvoice/soa-services/restapi/purchaseOrder/filter/purchaseOrder";//EINVOICE-12696
	public static final String getSupplierAccountGroups = "/einvoice/soa-services/restapi/supplier/supplierAccountGroups";//EINVOICE_13428
	public static final String getSupplierBankingDetails = "/einvoice/soa-services/restapi/supplier";//EINVOICE_12345
	public static final String getSupplierContact = "/einvoice/soa-services/restapi/supplier/supplierContact";//EINVOICE_13379



}
