class Post {
    constructor(id, title, description, created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
    }
    get short(){
        return this.description;
    }

}

class Store {
    get data(){
        return [new Post(1, "Goods", "Love JS", "1 ноября"), new Post(2, "Goods", "Love Java", "1 ноября")];
    }
}

module.exports = new Store;

