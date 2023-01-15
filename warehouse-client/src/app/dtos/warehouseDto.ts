export class WarehouseDto {

	id:number;
	uuid:string; 
	client:string; 
	family:string; 
	size:number; 

    constructor(id:number, uuid:string, client:string, family:string, size:number) {
        this.id = id;
        this.uuid = uuid;
        this.client = client;
        this.family = family;
        this.size = size;
    }
}