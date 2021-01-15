import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

import { StoreService } from '../store.service';
import { IStore } from '../istore';
import { BaseDetailsComponent, Globals, PickerDialogService, ErrorService } from 'src/app/common/shared';
import { GlobalPermissionService } from 'src/app/core/global-permission.service';

import { AddressService } from 'src/app/entities/address/address.service';
import { StaffService } from 'src/app/entities/staff/staff.service';

@Component({
  selector: 'app-store-details',
  templateUrl: './store-details.component.html',
  styleUrls: ['./store-details.component.scss']
})
export class StoreDetailsComponent extends BaseDetailsComponent<IStore> implements OnInit {
	title = 'Store';
	parentUrl = 'store';
	constructor(
		public formBuilder: FormBuilder,
		public router: Router,
		public route: ActivatedRoute,
		public dialog: MatDialog,
		public global: Globals,
		public storeService: StoreService,
		public pickerDialogService: PickerDialogService,
		public errorService: ErrorService,
		public addressService: AddressService,
		public staffService: StaffService,
		public globalPermissionService: GlobalPermissionService,
	) {
		super(formBuilder, router, route, dialog, global, pickerDialogService, storeService, errorService);
  }

	ngOnInit() {
		this.entityName = 'Store';
		this.setAssociations();
		super.ngOnInit();
		this.setForm();
    	this.getItem();
    	this.setPickerSearchListener();
	}
  
  setForm(){
    this.itemForm = this.formBuilder.group({
      storeId: [{value: '', disabled: true}, Validators.required],
      addressId: ['', Validators.required],
      addressDescriptiveField : ['', Validators.required],
      managerStaffId: ['', Validators.required],
      staffDescriptiveField : ['', Validators.required],
      
    });
    
    this.fields = [
			
      ];
      
  }
  
  onItemFetched(item: IStore) {
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
	    referencedDescriptiveField: 'district',
		},
      {
        column: [
	        {
	          key: 'managerStaffId',
	          value: undefined,
	          referencedkey: 'staffId'
			},
		],
		isParent: false,
		table: 'staff',
		type: 'ManyToOne',
		label: 'staff',
		service: this.staffService,
		descriptiveField: 'staffDescriptiveField',
	    referencedDescriptiveField: 'firstName',
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
		let store = this.itemForm.getRawValue();
		super.onSubmit(store);
		
	}
}
