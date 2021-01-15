import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

import { RentalService } from '../rental.service';
import { IRental } from '../irental';
import { BaseDetailsComponent, Globals, PickerDialogService, ErrorService } from 'src/app/common/shared';
import { GlobalPermissionService } from 'src/app/core/global-permission.service';

import { CustomerService } from 'src/app/entities/customer/customer.service';
import { InventoryService } from 'src/app/entities/inventory/inventory.service';
import { StaffService } from 'src/app/entities/staff/staff.service';

@Component({
  selector: 'app-rental-details',
  templateUrl: './rental-details.component.html',
  styleUrls: ['./rental-details.component.scss']
})
export class RentalDetailsComponent extends BaseDetailsComponent<IRental> implements OnInit {
	title = 'Rental';
	parentUrl = 'rental';
	constructor(
		public formBuilder: FormBuilder,
		public router: Router,
		public route: ActivatedRoute,
		public dialog: MatDialog,
		public global: Globals,
		public rentalService: RentalService,
		public pickerDialogService: PickerDialogService,
		public errorService: ErrorService,
		public customerService: CustomerService,
		public inventoryService: InventoryService,
		public staffService: StaffService,
		public globalPermissionService: GlobalPermissionService,
	) {
		super(formBuilder, router, route, dialog, global, pickerDialogService, rentalService, errorService);
  }

	ngOnInit() {
		this.entityName = 'Rental';
		this.setAssociations();
		super.ngOnInit();
		this.setForm();
    	this.getItem();
    	this.setPickerSearchListener();
	}
  
  setForm(){
    this.itemForm = this.formBuilder.group({
      rentalDate: [''],
      rentalId: [{value: '', disabled: true}, Validators.required],
      returnDate: [''],
      customerId: ['', Validators.required],
      customerDescriptiveField : ['', Validators.required],
      inventoryId: ['', Validators.required],
      inventoryDescriptiveField : ['', Validators.required],
      staffId: ['', Validators.required],
      staffDescriptiveField : ['', Validators.required],
      
    });
    
    this.fields = [
			
        {
		  name: 'rentalDate',
		  label: 'rental Date',
		  isRequired: false,
		  isAutoGenerated: false,
		  type: 'date',
	    },
			
			
        {
		  name: 'returnDate',
		  label: 'return Date',
		  isRequired: false,
		  isAutoGenerated: false,
		  type: 'date',
	    },
      ];
      
  }
  
  onItemFetched(item: IRental) {
    this.item = item;
    this.itemForm.patchValue(item);
    this.itemForm.get('rentalDate').setValue(item.rentalDate? new Date(item.rentalDate): null);
    this.itemForm.get('returnDate').setValue(item.returnDate? new Date(item.returnDate): null);
  }
  
  setAssociations(){
    this.associations = [
      {
        column: [
	        {
	          key: 'customerId',
	          value: undefined,
	          referencedkey: 'customerId'
			},
		],
		isParent: false,
		table: 'customer',
		type: 'ManyToOne',
		label: 'customer',
		service: this.customerService,
		descriptiveField: 'customerDescriptiveField',
	    referencedDescriptiveField: 'firstName',
		},
      {
        column: [
	        {
	          key: 'inventoryId',
	          value: undefined,
	          referencedkey: 'inventoryId'
			},
		],
		isParent: false,
		table: 'inventory',
		type: 'ManyToOne',
		label: 'inventory',
		service: this.inventoryService,
		descriptiveField: 'inventoryDescriptiveField',
	    referencedDescriptiveField: 'storeId',
		},
      {
        column: [
	        {
	          key: 'rentalId',
	          value: undefined,
	          referencedkey: 'rentalId'
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
	          key: 'staffId',
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
		let rental = this.itemForm.getRawValue();
		super.onSubmit(rental);
		
	}
}
