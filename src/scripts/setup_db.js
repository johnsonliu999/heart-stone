const mongoose = require('mongoose');
const unirest = require('unirest');

mongoose.connect('mongodb+srv://heart_stone:heart_stone@heart-stone-nres7.mongodb.net/heart-stone')
const db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', () => console.log('connect succeed'));

const cardSchema = mongoose.Schema({
    cardId: String,
    name: String,
    cardSet: String,
    type: String,
    text: String,
    race: String,
    playerClass: String,
    faction: String,
    rarity: String,
    health: Number,
    attack: Number,
    cost: Number,
    durability: Number,
    mechanics: Array,
    artist: String,
    flavor: String,
    img: String
});

const Card = mongoose.model('Card', cardSchema);

unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
    .header("X-Mashape-Key", "OSmIorlG6amshCBEGRU7LCUXobsBp1lV49Kjsnzxp5Ny5SWIHK")
    .query({collectible: 1})
    .header("X-Mashape-Host", "omgvamp-hearthstone-v1.p.mashape.com")
    .end(resp => {
        for (let key in resp.body) {
            resp.body[key].map(o => new Card(o).save(err => {
                if (err) console.error(err);
                else console.log('+ saved ', o.name);
            }))
        }
    });