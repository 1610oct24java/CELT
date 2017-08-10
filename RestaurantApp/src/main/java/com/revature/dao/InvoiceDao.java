package com.revature.dao;

import com.revature.beans.Invoice;
import com.revature.beans.InvoiceItem;

public interface InvoiceDao {

	void saveInvoice(Invoice invoice);

	void saveInvoiceItem(InvoiceItem i);

}
