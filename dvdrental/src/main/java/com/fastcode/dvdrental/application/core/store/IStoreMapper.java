package com.fastcode.dvdrental.application.core.store;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.fastcode.dvdrental.domain.core.address.AddressEntity;
import com.fastcode.dvdrental.domain.core.staff.StaffEntity;
import com.fastcode.dvdrental.application.core.store.dto.*;
import com.fastcode.dvdrental.domain.core.store.StoreEntity;
import java.time.*;

@Mapper(componentModel = "spring")
public interface IStoreMapper {

   StoreEntity createStoreInputToStoreEntity(CreateStoreInput storeDto);
   
   
   @Mappings({ 
   @Mapping(source = "entity.address.addressId", target = "addressId"),                   
   @Mapping(source = "entity.address.district", target = "addressDescriptiveField"),                    
   @Mapping(source = "entity.staff.staffId", target = "managerStaffId"),                   
   @Mapping(source = "entity.staff.firstName", target = "staffDescriptiveField"),                    
   }) 
   CreateStoreOutput storeEntityToCreateStoreOutput(StoreEntity entity);
   
    StoreEntity updateStoreInputToStoreEntity(UpdateStoreInput storeDto);
    
    @Mappings({ 
    @Mapping(source = "entity.address.addressId", target = "addressId"),                   
    @Mapping(source = "entity.address.district", target = "addressDescriptiveField"),                    
    @Mapping(source = "entity.staff.staffId", target = "managerStaffId"),                   
    @Mapping(source = "entity.staff.firstName", target = "staffDescriptiveField"),                    
   	}) 
   	UpdateStoreOutput storeEntityToUpdateStoreOutput(StoreEntity entity);

   	@Mappings({ 
   	@Mapping(source = "entity.address.addressId", target = "addressId"),                   
   	@Mapping(source = "entity.address.district", target = "addressDescriptiveField"),                    
   	@Mapping(source = "entity.staff.staffId", target = "managerStaffId"),                   
   	@Mapping(source = "entity.staff.firstName", target = "staffDescriptiveField"),                    
   	}) 
   	FindStoreByIdOutput storeEntityToFindStoreByIdOutput(StoreEntity entity);


   @Mappings({
   @Mapping(source = "staff.storeId", target = "storeId"),                  
   @Mapping(source = "foundStore.storeId", target = "storeStoreId"),
   })
   GetStaffOutput staffEntityToGetStaffOutput(StaffEntity staff, StoreEntity foundStore);
   
   @Mappings({
   @Mapping(source = "address.address", target = "address"),                  
   @Mapping(source = "foundStore.storeId", target = "storeStoreId"),
   })
   GetAddressOutput addressEntityToGetAddressOutput(AddressEntity address, StoreEntity foundStore);
   
}

