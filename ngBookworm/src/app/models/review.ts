export class Review {

  description: string;

  title: string;

  synopsis: string;

  coverArt: string;

  dateCreated: string;

  dateUpdated: string;
//TODO fix ur shit nerd


  constructor(
    description: string = "",
    title: string = "",
    synopsis: string = "",
    coverArt: string = "",
    dateCreated: string = "",
    dateUpdated: string = "") {
    this.description = description;
    this.title = title;
    this.synopsis = synopsis;
    this.coverArt = coverArt;
    this.dateCreated = dateCreated;
    this.dateUpdated = dateUpdated;
  }


}
