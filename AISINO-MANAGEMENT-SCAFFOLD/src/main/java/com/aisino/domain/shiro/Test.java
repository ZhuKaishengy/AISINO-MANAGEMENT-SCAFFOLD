package com.aisino.domain.shiro;

import java.math.BigDecimal;

public class Test extends TestKey {
    private String type;

    private String extend;

    private String billnumber;

    private String buyername;

    private String buyertaxcode;

    private String buyeraddressphone;

    private String buyerbankaccount;

    private String sellername;

    private String sellertaxcode;

    private String selleraddressphone;

    private String sellerbankaccount;

    private String createdate;

    private String month;

    private BigDecimal amount;

    private BigDecimal taxrate;

    private BigDecimal tax;

    private String maindetailname;

    private String memo;

    private String invoicer;

    private String cashier;

    private String checker;

    private String isprinted;

    private String islisted;

    private String iscanceled;

    private String authcode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public String getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(String billnumber) {
        this.billnumber = billnumber == null ? null : billnumber.trim();
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername == null ? null : buyername.trim();
    }

    public String getBuyertaxcode() {
        return buyertaxcode;
    }

    public void setBuyertaxcode(String buyertaxcode) {
        this.buyertaxcode = buyertaxcode == null ? null : buyertaxcode.trim();
    }

    public String getBuyeraddressphone() {
        return buyeraddressphone;
    }

    public void setBuyeraddressphone(String buyeraddressphone) {
        this.buyeraddressphone = buyeraddressphone == null ? null : buyeraddressphone.trim();
    }

    public String getBuyerbankaccount() {
        return buyerbankaccount;
    }

    public void setBuyerbankaccount(String buyerbankaccount) {
        this.buyerbankaccount = buyerbankaccount == null ? null : buyerbankaccount.trim();
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername == null ? null : sellername.trim();
    }

    public String getSellertaxcode() {
        return sellertaxcode;
    }

    public void setSellertaxcode(String sellertaxcode) {
        this.sellertaxcode = sellertaxcode == null ? null : sellertaxcode.trim();
    }

    public String getSelleraddressphone() {
        return selleraddressphone;
    }

    public void setSelleraddressphone(String selleraddressphone) {
        this.selleraddressphone = selleraddressphone == null ? null : selleraddressphone.trim();
    }

    public String getSellerbankaccount() {
        return sellerbankaccount;
    }

    public void setSellerbankaccount(String sellerbankaccount) {
        this.sellerbankaccount = sellerbankaccount == null ? null : sellerbankaccount.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getMaindetailname() {
        return maindetailname;
    }

    public void setMaindetailname(String maindetailname) {
        this.maindetailname = maindetailname == null ? null : maindetailname.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getInvoicer() {
        return invoicer;
    }

    public void setInvoicer(String invoicer) {
        this.invoicer = invoicer == null ? null : invoicer.trim();
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier == null ? null : cashier.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public String getIsprinted() {
        return isprinted;
    }

    public void setIsprinted(String isprinted) {
        this.isprinted = isprinted == null ? null : isprinted.trim();
    }

    public String getIslisted() {
        return islisted;
    }

    public void setIslisted(String islisted) {
        this.islisted = islisted == null ? null : islisted.trim();
    }

    public String getIscanceled() {
        return iscanceled;
    }

    public void setIscanceled(String iscanceled) {
        this.iscanceled = iscanceled == null ? null : iscanceled.trim();
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode == null ? null : authcode.trim();
    }
}