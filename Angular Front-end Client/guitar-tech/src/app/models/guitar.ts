export class Guitar {
    constructor(
        public brandId: string,
        public brandName: string,
        public model: string,
        public numberOfFrets: number,
        public numberOfStrings: number,
        public numberOfPickups: number,
        public pickupsType: string,
        public price: number
    ) {}
}
