package com.fastcode.dvdrental.application.core.customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.fastcode.dvdrental.domain.core.address.AddressEntity;
import com.fastcode.dvdrental.application.core.customer.dto.*;
import com.fastcode.dvdrental.domain.core.customer.CustomerEntity;
import java.time.*;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

   CustomerEntity createCustomerInputToCustomerEntity(CreateCustomerInput customerDto);
   
   
   @Mappings({ 
   @Mapping(source = "entity.address.addressId", target = "addressId"),                   
   @Mapping(source = "entity.address.district", target = "addressDescriptiveField"),                    
   }) 
   CreateCustomerOutput customerEntityToCreateCustomerOutput(CustomerEntity entity);
   
    CustomerEntity updateCustomerInputToCustomerEntity(UpdateCustomerInput customerDto);
    
    @Mappings({ 
    @Mapping(source = "entity.address.addressId", target = "addressId"),                   
    @Mapping(source = "entity.address.district", target = "addressDescriptiveField"),                    
   	}) 
   	UpdateCustomerOutput customerEntityToUpdateCustomerOutput(CustomerEntity entity);

   	@Mappings({ 
   	@Mapping(source = "entity.address.addressId", target = "addressId"),                   
   	@Mapping(source = "entity.address.district", target = "addressDescriptiveField"),                    
   	}) 
   	FindCustomerByIdOutput customerEntityToFindCustomerByIdOutput(CustomerEntity entity);


   @Mappings({
   @Mapping(source = "address.address", target = "address"),                  
   @Mapping(source = "foundCustomer.customerId", target = "customerCustomerId"),
   })
   GetAddressOutput addressEntityToGetAddressOutput(AddressEntity address, CustomerEntity foundCustomer);
   
}
