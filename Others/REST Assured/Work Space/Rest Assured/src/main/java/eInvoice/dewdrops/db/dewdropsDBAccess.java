package eInvoice.dewdrops.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eInvoice.dewdrops.util.TestUtil;


public class dewdropsDBAccess {
	public Connection mConnection = null;

	/**
	 * Method to get DB connection
	 * 
	 * @return
	 */

	public Connection getConnection() {

		String databaseDriverName = TestUtil.getDBDriverName();

		try {
			mConnection = DriverManager.getConnection(databaseDriverName, TestUtil.getDBUserName(), TestUtil.getDBPassword());
			
			if (mConnection != null) {
	//			System.out.println("************************ Connection has been established successfully *******************");
			}
		} catch (SQLException e) {
			System.out.println("Exception occured while connecting to DB:" + e.toString());
		}
		return mConnection;
	}

	/**
	 * Method to close DB Connection
	 * 
	 */
	public void closeConnection() {
		try {
			mConnection.close();
		} catch (SQLException e) {
			System.out
					.println("**************** Exception occured while closing the DB ***************" + e.toString());
		}
		finally {
			System.out.println("Connection close sucessfully");
		}
	}

	/**
	 * Method to get column Value
	 * 
	 * @param query
	 * @param columnLabel
	 * @return
	 */

	public String getColumnValue(String query, String columnLabel) {
		System.out.println(" Query : " + query);

		ResultSet resultSet = null;
		try {
			m_preparedStatement = mConnection.prepareStatement(query);
			resultSet = m_preparedStatement.executeQuery();

			if (resultSet != null) {
				resultSet.next();
			}
			return resultSet.getString(columnLabel);
		} catch (Exception e) {

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (m_preparedStatement != null) {
					m_preparedStatement.close();
					m_preparedStatement = null;
				}
				if (m_statement != null) {
					m_statement.close();
					m_statement = null;
				}
			} catch (SQLException e) {
				System.out.println("Exception occured while closing the statements");
			}
		}
		return null;
	}
	
	public ArrayList<String> getColumnValue1(String query, String columnLabel) {
		//System.out.println(" Query : " + query);

		ResultSet resultSet = null;
		try {
			m_preparedStatement = mConnection.prepareStatement(query);
			resultSet = m_preparedStatement.executeQuery();
			ArrayList<String> resultList = new ArrayList<String>();
			while (resultSet.next()) {
			        resultList.add(resultSet.getString(columnLabel));
			    }
			return resultList;
		} catch (Exception e) {

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (m_preparedStatement != null) {
					m_preparedStatement.close();
					m_preparedStatement = null;
				}
				if (m_statement != null) {
					m_statement.close();
					m_statement = null;
				}
			} catch (SQLException e) {
				System.out.println("Exception occured while closing the statements");
			}
		}
		return null;
	}
	
	/**
	 * Below function will Give a random invoice id 
	 * @param coloumnName
	 * @return
	 */
	
	public String getInvoiceDetails(String coloumnName, String tenantID,String userdID) {
		String query =  "select "+coloumnName+" from eproc_invoice where tenant_id='"+tenantID+"' and created_by='"+userdID+"'";
		return getColumnValue(query, coloumnName);
	}
	
	public String getCreditMemoDetails(String coloumnName, String tenantID,String userdID) {
		String query =  "select "+coloumnName+" from einvoice_credit_memo where tenant_id='"+tenantID+"' and created_by='"+userdID+"'";
		return getColumnValue(query, coloumnName);
	}
	
	
	public String getFilterId(String coloumnName) {
		String query = String.format("select %s from einvoice_user_filter_data where ROWNUM=1;", coloumnName);
		return getColumnValue(query, coloumnName);
		
	}

	public ArrayList<String> getAttachmentIds(String coloumnName, String tenantID,String userdID,String attachmentname) {
		String query = "select "+coloumnName+" from eproc_attachment where tenant_id='"+tenantID+"' and created_by='"+userdID+"' and name='"+attachmentname+"'";
		return getColumnValue1(query, coloumnName);
		
	}
	
	public String getAttachmentId(String coloumnName,String tenantID,String userdID) {
		String query ="select "+coloumnName+" from eproc_attachment where tenant_id='"+tenantID+"' and created_by='"+userdID+"'";
		return getColumnValue(query, coloumnName);		
	}
	
	public String getFilterDetails(String coloumnName, String tenantID,String userdID) {
		String query =  "select "+coloumnName+" from einvoice_user_filter_data where tenant_id='"+tenantID+"' and user_id='"+userdID+"'";
		return getColumnValue(query, coloumnName);
	}
	public String getProcessEform(String coloumnName, String tenantID) {
		String query =  "select "+coloumnName+" from eproc_eform_process where tenant_id='"+tenantID+"'";
		return getColumnValue(query, coloumnName);
	}

	private PreparedStatement m_preparedStatement = null;

	private Statement m_statement = null;



}
