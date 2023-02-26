package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_donation")

public class ItemDonation extends BaseEntity{
	@Column(length = 20)
	private String itemType;

	@Column(length = 10)
	private String itemPicViaDonator;
	@Column(length = 10)
	private String itemPicViaEmployee;

	
	
	@ManyToOne
	@JoinColumn(name="donor_id")
	private Donor itemDonor;
}
