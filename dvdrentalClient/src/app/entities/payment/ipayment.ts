export interface IPayment {  
	amount: number;
	paymentDate?: Date;
	paymentId: number;

	customerDescriptiveField?: string;
	customerId: number;
	rentalDescriptiveField?: number;
	rentalId: number;
	staffDescriptiveField?: string;
	staffId: number;
}
