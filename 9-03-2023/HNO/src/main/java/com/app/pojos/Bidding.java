package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="bidding")
public class Bidding extends BaseEntity {
	private double lowPriceToy;
	private double lowPriceCloth;
	private double lowPriceNotebook;
	private double lowPriceCycle;
	@CreationTimestamp
	private Date dateOfBid;
	@Column(length = 8, columnDefinition = "varchar(8) default 'APPLIED'")
	@Enumerated(value = EnumType.STRING)
	private BiddingStatus biddingStatusApprove;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendorBidding;

	public Bidding(double lowPriceToy, double lowPriceCloth, double lowPriceNotebook, double lowPriceCycle,
			Date dateOfBid, BiddingStatus biddingStatusApprove, Vendor vendorBidding,int quantity) {
		super();
		this.lowPriceToy = lowPriceToy;
		this.lowPriceCloth = lowPriceCloth;
		this.lowPriceNotebook = lowPriceNotebook;
		this.lowPriceCycle = lowPriceCycle;
		this.dateOfBid = dateOfBid;
		this.biddingStatusApprove = biddingStatusApprove;
		this.vendorBidding = vendorBidding;
		this.quantity=quantity;
	}

	public Bidding() {
		super();
	}

	public double getLowPriceToy() {
		return lowPriceToy;
	}

	public void setLowPriceToy(double lowPriceToy) {
		this.lowPriceToy = lowPriceToy;
	}

	public double getLowPriceCloth() {
		return lowPriceCloth;
	}

	public void setLowPriceCloth(double lowPriceCloth) {
		this.lowPriceCloth = lowPriceCloth;
	}

	public double getLowPriceNotebook() {
		return lowPriceNotebook;
	}

	public void setLowPriceNotebook(double lowPriceNotebook) {
		this.lowPriceNotebook = lowPriceNotebook;
	}

	public double getLowPriceCycle() {
		return lowPriceCycle;
	}

	public void setLowPriceCycle(double lowPriceCycle) {
		this.lowPriceCycle = lowPriceCycle;
	}

	public Date getDateOfBid() {
		return dateOfBid;
	}

	public void setDateOfBid(Date dateOfBid) {
		this.dateOfBid = dateOfBid;
	}

	public BiddingStatus getBiddingStatusApprove() {
		return biddingStatusApprove;
	}

	public void setBiddingStatusApprove(BiddingStatus biddingStatusApprove) {
		this.biddingStatusApprove = biddingStatusApprove;
	}

	public Vendor getVendor() {
		return vendorBidding;
	}

	public void setVendor(Vendor vendorBidding) {
		this.vendorBidding = vendorBidding;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Bidding [lowPriceToy=" + lowPriceToy + ", lowPriceCloth=" + lowPriceCloth + ", lowPriceNotebook="
				+ lowPriceNotebook + ", lowPriceCycle=" + lowPriceCycle + ", dateOfBid=" + dateOfBid
				+ ", biddingStatusApprove=" + biddingStatusApprove + ", vendor=" + vendorBidding + "]";
	}

}
