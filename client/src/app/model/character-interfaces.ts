export interface MarvelApiResponse {
    code: number;
    status: string;
    copyright: string;
    attributionText: string;
    attributionHTML: string;
    data: MarvelData;
    etag: string;
}

export interface MarvelData {
    offset: number;
    limit: number;
    total: number;
    count: number;
    results: MarvelCharacter[];
}

export interface MarvelCharacter {
    id: number;
    name: string;
    description: string;
    modified: Date;
    resourceURI: string;
    urls: MarvelUrl[];
    thumbnail: MarvelThumbnail;
    comics: MarvelItemsContainer;
    stories: MarvelStories;
    events: MarvelItemsContainer;
    series: MarvelItemsContainer;
}

export interface MarvelUrl {
    type: string;
    url: string;
}

export interface MarvelThumbnail {
    path: string;
    extension: string;
}

export interface MarvelItemsContainer {
    available: number;
    returned: number;
    collectionURI: string;
    items: MarvelItem[];
}

export interface MarvelStories extends MarvelItemsContainer {
    items: MarvelStoryItem[];
}

export interface MarvelItem {
    resourceURI: string;
    name: string;
}

export interface MarvelStoryItem extends MarvelItem {
    type: string;
}