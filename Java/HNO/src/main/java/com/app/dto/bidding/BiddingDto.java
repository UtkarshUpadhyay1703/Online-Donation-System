package com.app.dto.bidding;

import com.app.pojos.BiddingStatus;
import com.app.pojos.Vendor;

public class BiddingDto {
	private double lowPriceToy;
	private double lowPriceCloth;
	private double lowPriceNotebook;
	private double lowPriceCycle;
	private BiddingStatus biddingStatusApprove;
	private Vendor vendorBidding;

	public BiddingDto(double lowPriceToy, double lowPriceCloth, double lowPriceNotebook, double lowPriceCycle,
			BiddingStatus biddingStatusApprove, Vendor vendorBidding) {
		super();
		this.lowPriceToy = lowPriceToy;
		this.lowPriceCloth = lowPriceCloth;
		this.lowPriceNotebook = lowPriceNotebook;
		this.lowPriceCycle = lowPriceCycle;
		this.biddingStatusApprove = biddingStatusApprove;
		this.vendorBidding = vendorBidding;
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

	public BiddingStatus getBiddingStatusApprove() {
		return biddingStatusApprove;
	}

	public void setBiddingStatusApprove(BiddingStatus biddingStatusApprove) {
		this.biddingStatusApprove = biddingStatusApprove;
	}

	public Vendor getVendorBidding() {
		return vendorBidding;
	}

	public void setVendorBidding(Vendor vendorBidding) {
		this.vendorBidding = vendorBidding;
	}

	@Override
	public String toString() {
		return "BiddingDto [lowPriceToy=" + lowPriceToy + ", lowPriceCloth=" + lowPriceCloth + ", lowPriceNotebook="
				+ lowPriceNotebook + ", lowPriceCycle=" + lowPriceCycle + ", biddingStatusApprove="
				+ biddingStatusApprove + ", vendorBidding=" + vendorBidding + "]";
	}

}