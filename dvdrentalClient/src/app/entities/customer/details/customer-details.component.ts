import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

import { CustomerService } from '../customer.service';
import { ICustomer } from '../icustomer';
import { BaseDetailsComponent, Globals, PickerDialogService, ErrorService } from 'src/app/common/shared';
import { GlobalPermissionService } from 'src/app/core/global-permission.service';

import { AddressService } from 'src/app/entities/address/address.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.scss']
})
export class CustomerDetailsComponent extends BaseDetailsComponent<ICustomer> implements OnInit {
	title = 'Customer';
	parentUrl = 'customer';
	constructor(
		public formBuilder: FormBuilder,
		public router: Router,
		public route: ActivatedRoute,
		public dialog: MatDialog,
		public global: Globals,
		public customerService: CustomerService,
		public pickerDialogService: PickerDialogService,
		public errorService: ErrorService,
		public addressService: AddressService,
		public globalPermissionService: GlobalPermissionService,
	) {
		super(formBuilder, router, route, dialog, global, pickerDialogService, customerService, errorService);
  }

	ngOnInit() {
		this.entityName = 'Customer';
		this.setAssociations();
		super.ngOnInit();
		this.setForm();
    	this.getItem();
    	this.setPickerSearchListener();
	}
  
  setForm(){
    this.itemForm = this.formBuilder.group({
      active: [''],
      activebool: [false, Validators.required],
      customerId: [{value: '', disabled: true}, Validators.required],
      email: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      storeId: ['', Validators.required],
      addressId: ['', Validators.required],
      addressDescriptiveField : ['', Validators.required],
      
    });
    
    this.fields = [
			
        {
		  name: 'active',
		  label: 'active',
		  isRequired: false,
		  isAutoGenerated: false,
	      type: 'number',
	    },
			
        {
		  name: 'activebool',
		  label: 'activebool',
		  isRequired: true,
		  isAutoGenerated: false,
          type: 'boolean',
	    },
			
			
        {
		  name: 'email',
		  label: 'email',
		  isRequired: false,
		  isAutoGenerated: false,
	      type: 'string',
	    },
			
        {
		  name: 'firstName',
		  label: 'first Name',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'string',
	    },
			
        {
		  name: 'lastName',
		  label: 'last Name',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'string',
	    },
			
        {
		  name: 'storeId',
		  label: 'store Id',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'number',
	    },
      ];
      
  }
  
  onItemFetched(item: ICustomer) {
    this.item = item;
    this.itemForm.patchValue(item);
  }
  
  setAssociations(){
    this.associations = [
      {
        column: [
	        {
	          key: 'addressId',
	          value: undefined,
	          referencedkey: 'addressId'
			},
		],
		isParent: false,
		table: 'address',
		type: 'ManyToOne',
		label: 'address',
		service: this.addressService,
		descriptiveField: 'addressDescriptiveField',
	    referencedDescriptiveField: 'addressId',
		},
      {
        column: [
	        {
	          key: 'customerId',
	          value: undefined,
	          referencedkey: 'customerId'
			},
		],
		isParent: true,
		table: 'payment',
		type: 'OneToMany',
		label: 'payments',
		},
      {
        column: [
	        {
	          key: 'customerId',
	          value: undefined,
	          referencedkey: 'customerId'
			},
		],
		isParent: true,
		table: 'rental',
		type: 'OneToMany',
		label: 'rentals',
		},
		];
		
		this.childAssociations = this.associations.filter(association => {
			return (association.isParent);
		});

		this.parentAssociations = this.associations.filter(association => {
			return (!association.isParent);
		});
	}
	
	onSubmit() {
		let customer = this.itemForm.getRawValue();
		super.onSubmit(customer);
		
	}
}
