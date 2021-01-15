export interface IRental {  
	rentalDate?: Date;
	rentalId: number;
	returnDate?: Date;

	customerDescriptiveField?: string;
	customerId: number;
	inventoryDescriptiveField?: number;
	inventoryId: number;
	staffDescriptiveField?: string;
	staffId: number;
}
