package vn.edu.uel.nghiatd17411;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.uel.nghiatd17411.model.Buyer;
import vn.edu.uel.nghiatd17411.model.Invoice;
import vn.edu.uel.nghiatd17411.model.ShippingCenter;
import vn.edu.uel.nghiatd17411.model.Supplier;

public class InvoiceActivity extends AppCompatActivity {
    public Invoice get_invoice() {
        return _invoice;
    }

    public void set_invoice(Invoice invoice) {
        this._invoice = invoice;
        _txtInvoice_id.setText("# "+invoice.getId()+"");
        _txtInvoice_date.setText(invoice.get_invoiceDate());
        _imgV_Supplier_Img.setImageResource(invoice.get_supplier().getHinh());
        _txtSupplierName.setText(invoice.get_supplier().getName());
        _txtSupplierPhone.setText(invoice.get_supplier().getPhone());
        _txtSupplierAddress.setText(invoice.get_supplier().getAddress());
        _imgV_Buyer_Img.setImageResource(invoice.get_buyer().getHinh());
        _txtBuyerName.setText(invoice.get_buyer().getName());
        _txtBuyerPhone.setText(invoice.get_buyer().getPhone());
        _txtBuyerAddress.setText(invoice.get_buyer().getAddress());
        _imgV_Ship_Img.setImageResource(invoice.get_shipping().getHinh());
        _txtShipName.setText(invoice.get_shipping().getName());
        _txtShippingFee.setText(invoice.get_shippingFee()+"");
        _txtShippingPeriod.setText(invoice.get_shippingPeriod());
        _txtPaymentMethod.setText(invoice.get_paymentMethod());
        _txtOnBills.setText(invoice.get_onBillsValue()+"");
        _txtPaymentShippingFee.setText(invoice.get_shippingFee()+"");
        _txtTotalAmount.setText(""+(invoice.get_onBillsValue()+invoice.get_shippingFee()));
    }

    Invoice _invoice;
    TextView _txtInvoice_id;
    TextView _txtInvoice_date;
    ImageView _imgV_Supplier_Img;
    TextView _txtSupplierName;
    TextView _txtSupplierPhone;
    TextView _txtSupplierAddress;
    ImageView _imgV_Buyer_Img;
    TextView _txtBuyerName;
    TextView _txtBuyerPhone;
    TextView _txtBuyerAddress;
    ImageView _imgV_Ship_Img;
    TextView _txtShipName;
    TextView _txtShippingFee;
    TextView _txtShippingPeriod;
    TextView _txtPaymentMethod;
    TextView _txtOnBills;
    TextView _txtPaymentShippingFee;
    TextView _txtTotalAmount;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_layout);
        addControls();
        addFakeData();

    }

    private void addFakeData() {
        //
        int supplier_id = 123456789;
        int supplier_img_id = R.drawable.mr_mobile;
        String supplier_name = "Official Store";
        String supplier_phone ="(84) 983052921";
        String supplier_address ="12 Nguyen Trong Loi, ward 4, Tan Binh distric";
        Supplier supplier = new Supplier(supplier_id,supplier_name,supplier_img_id,supplier_phone,supplier_address);
        //
        int buyer_id = 987654321;
        int buyer_img_id = R.drawable.asus;
        String buyer_name="Shop";
        String buyer_phone ="(84) 984883925";
        String buyer_address="103 B C1 CC K300, ward 12, Tan Binh distric";
        Buyer buyer = new Buyer(buyer_id,buyer_name,buyer_img_id,buyer_phone,buyer_address);
        //
        int shipping_id = 976786745;
        int shipping_img_id = R.drawable.logo_ghtk;
        String shipping_name="Giao Hang Nhanh";
        String shipping_phone="(85) 675 897 324";
        String shipping_address ="Cau Long Kim, Ben Luc, Long An";
        ShippingCenter shippingCenter = new ShippingCenter(shipping_id,shipping_name,shipping_img_id,shipping_phone,shipping_address);
        //
        int invoide_id = 123456231;
        String invoice_date ="20 Dec 2019";
        String invoice_shipping_period ="15 Jul - 17 Jul";
        String invoice_paymentMethod="By COD";
        double invoice_onBills = 12345;
        double invoice_shippingFee = 5.7;
        Invoice invoice = new Invoice(invoide_id,buyer,shippingCenter,supplier,invoice_shipping_period,invoice_onBills,invoice_shippingFee,invoice_date,invoice_paymentMethod);
        //
//        this._invoice = invoice;
//        //
//        _txtInvoice_id.setText("# "+invoice.getId()+"");
//        _txtInvoice_date.setText(invoice.get_invoiceDate());
//        _imgV_Supplier_Img.setImageResource(invoice.get_supplier().getHinh());
//        _txtSupplierName.setText(invoice.get_supplier().getName());
//        _txtSupplierPhone.setText(invoice.get_supplier().getPhone());
//        _txtSupplierAddress.setText(invoice.get_supplier().getAddress());
//        _imgV_Buyer_Img.setImageResource(invoice.get_buyer().getHinh());
//        _txtBuyerName.setText(invoice.get_buyer().getName());
//        _txtBuyerPhone.setText(invoice.get_buyer().getPhone());
//        _txtBuyerAddress.setText(invoice.get_buyer().getAddress());
//        _imgV_Ship_Img.setImageResource(invoice.get_shipping().getHinh());
//        _txtShipName.setText(invoice.get_shipping().getName());
//        _txtShippingFee.setText(invoice.get_shippingFee()+"");
//        _txtShippingPeriod.setText(invoice.get_shippingPeriod());
//        _txtPaymentMethod.setText(invoice.get_paymentMethod());
//        _txtOnBills.setText(invoice.get_onBillsValue()+"");
//        _txtPaymentShippingFee.setText(invoice.get_shippingFee()+"");
//        _txtTotalAmount.setText(""+(invoice.get_onBillsValue()+invoice.get_shippingFee()));
        set_invoice(invoice);

    }

    private void addControls() {
        _txtInvoice_id = findViewById(R.id.invoice_id);
        _txtInvoice_date =findViewById(R.id.invoice_date);
        _imgV_Supplier_Img = findViewById(R.id.supplier_img);
        _txtSupplierName = findViewById(R.id.supplier_name);
        _txtSupplierPhone = findViewById(R.id.supplier_phone);
        _txtSupplierAddress =findViewById(R.id.supplier_address);
        _imgV_Buyer_Img = findViewById(R.id.buyer_img);
        _txtBuyerName = findViewById(R.id.buyer_name);
        _txtBuyerPhone = findViewById(R.id.buyer_phone);
        _txtBuyerAddress =findViewById(R.id.buyer_address);
        _imgV_Ship_Img = findViewById(R.id.ship_img);
        _txtShipName = findViewById(R.id.shipping_name);
        _txtShippingFee = findViewById(R.id.shipping_fee);
        _txtShippingPeriod = findViewById(R.id.shipping_period);
        _txtPaymentMethod = findViewById(R.id.payment_method);
        _txtOnBills = findViewById(R.id.on_bills);
        _txtPaymentShippingFee =findViewById(R.id.payment_shipping_fee);
        _txtTotalAmount = findViewById(R.id.total_amount);
    }


}
