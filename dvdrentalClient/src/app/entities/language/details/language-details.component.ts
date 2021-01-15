import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

import { LanguageService } from '../language.service';
import { ILanguage } from '../ilanguage';
import { BaseDetailsComponent, Globals, PickerDialogService, ErrorService } from 'src/app/common/shared';
import { GlobalPermissionService } from 'src/app/core/global-permission.service';


@Component({
  selector: 'app-language-details',
  templateUrl: './language-details.component.html',
  styleUrls: ['./language-details.component.scss']
})
export class LanguageDetailsComponent extends BaseDetailsComponent<ILanguage> implements OnInit {
	title = 'Language';
	parentUrl = 'language';
	constructor(
		public formBuilder: FormBuilder,
		public router: Router,
		public route: ActivatedRoute,
		public dialog: MatDialog,
		public global: Globals,
		public languageService: LanguageService,
		public pickerDialogService: PickerDialogService,
		public errorService: ErrorService,
		public globalPermissionService: GlobalPermissionService,
	) {
		super(formBuilder, router, route, dialog, global, pickerDialogService, languageService, errorService);
  }

	ngOnInit() {
		this.entityName = 'Language';
		this.setAssociations();
		super.ngOnInit();
		this.setForm();
    	this.getItem();
    	this.setPickerSearchListener();
	}
  
  setForm(){
    this.itemForm = this.formBuilder.group({
      languageId: ['', Validators.required],
      name: ['', Validators.required],
      
    });
    
    this.fields = [
			
        {
		  name: 'languageId',
		  label: 'language Id',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'number',
	    },
			
        {
		  name: 'name',
		  label: 'name',
		  isRequired: true,
		  isAutoGenerated: false,
	      type: 'string',
	    },
      ];
      
  }
  
  onItemFetched(item: ILanguage) {
    this.item = item;
    this.itemForm.patchValue(item);
  }
  
  setAssociations(){
    this.associations = [
      {
        column: [
	        {
	          key: 'languageId',
	          value: undefined,
	          referencedkey: 'languageId'
			},
		],
		isParent: true,
		table: 'film',
		type: 'OneToMany',
		label: 'films',
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
		let language = this.itemForm.getRawValue();
		super.onSubmit(language);
		
	}
}