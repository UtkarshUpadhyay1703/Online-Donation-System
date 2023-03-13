package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_donation")

public class ItemDonation extends BaseEntity {
	@Column(length = 20)
	private String itemType;

	@Column(length = 100)
	private String itemPicViaDonator;
	@Column(length = 100)
	private String itemPicViaEmployee;

	private boolean itemStatusDonation;

	@ManyToOne
	@JoinColumn(name = "donor_id")
	private Donor itemDonor;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee itemEmployee;

	public ItemDonation(String itemType, String itemPicViaDonator, String itemPicViaEmployee,
			boolean itemStatusDonation, Donor itemDonor, Employee itemEmployee) {
		super();
		this.itemType = itemType;
		this.itemPicViaDonator = itemPicViaDonator;
		this.itemPicViaEmployee = itemPicViaEmployee;
		this.itemStatusDonation = itemStatusDonation;
		this.itemDonor = itemDonor;
		this.itemEmployee = itemEmployee;
	}
	

	public ItemDonation(String itemPicViaEmployee, boolean itemStatusDonation, Employee itemEmployee) {
		super();
		this.itemPicViaEmployee = itemPicViaEmployee;
		this.itemStatusDonation = itemStatusDonation;
		this.itemEmployee = itemEmployee;
	}


	public ItemDonation(String itemType, String itemPicViaDonator, boolean itemStatusDonation, Donor itemDonor) {
		super();
		this.itemType = itemType;
		this.itemPicViaDonator = itemPicViaDonator;
		this.itemStatusDonation = itemStatusDonation;
		this.itemDonor = itemDonor;
	}
	
	



	public ItemDonation() {
		super();
	}


	public Donor getItemDonor() {
		return itemDonor;
	}

	public void setItemDonor(Donor itemDonor) {
		this.itemDonor = itemDonor;
	}

	public Employee getItemEmployee() {
		return itemEmployee;
	}

	public void setItemEmployee(Employee itemEmployee) {
		this.itemEmployee = itemEmployee;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemPicViaDonator() {
		return itemPicViaDonator;
	}

	public void setItemPicViaDonator(String itemPicViaDonator) {
		this.itemPicViaDonator = itemPicViaDonator;
	}

	public String getItemPicViaEmployee() {
		return itemPicViaEmployee;
	}

	public void setItemPicViaEmployee(String itemPicViaEmployee) {
		this.itemPicViaEmployee = itemPicViaEmployee;
	}

	public boolean isItemStatusDonation() {
		return itemStatusDonation;
	}

	public void setItemStatusDonation(boolean itemStatusDonation) {
		this.itemStatusDonation = itemStatusDonation;
	}

	@Override
	public String toString() {
		return "ItemDonation [itemType=" + itemType + ", itemPicViaDonator=" + itemPicViaDonator
				+ ", itemPicViaEmployee=" + itemPicViaEmployee + ", itemStatusDonation=" + itemStatusDonation
				+ ", itemDonor=" + itemDonor + ", itemEmployee=" + itemEmployee + "]";
	}

}
