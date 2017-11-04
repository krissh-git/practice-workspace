const mongoose = require('mongoose');
const Schema = mongoose.Schema;;


const TechStackItem = new Schema({
    name: String,
    category: String
})


module.exports = mongoose.model('techStackItem', TechStackItem, 'stacks');




