export class Review {
  id: number;

  description: string;

  title: string;

  synopsis: string;

  coverArt: string;

  dateCreated: string;

  dateUpdated: string;
  //TODO fix ur shit nerd

  constructor(
    id: number = 0,
    description: string = '',
    title: string = '',
    synopsis: string = '',
    coverArt: string = '',
    dateCreated: string = '',
    dateUpdated: string = ''
  ) {
    this.id = id;
    this.description = description;
    this.title = title;
    this.synopsis = synopsis;
    this.coverArt = coverArt;
    this.dateCreated = dateCreated;
    this.dateUpdated = dateUpdated;
  }
}
