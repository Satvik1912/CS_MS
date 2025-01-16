package com.cars24.dao;

public interface InvoiceDao {
    void createInvoice(int appointmentId, double amount, String paymentStatus);
    void updateInvoice(int invoiceId, double amount, String paymentStatus);
    void deleteInvoice(int invoiceId);
    void readInvoice(int invoiceId);
    void readAllInvoices();
}
