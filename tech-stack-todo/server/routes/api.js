const express = require('express');
const mongoose = require('mongoose');
const router = express.Router();
const TechStackItem = require('../../src/models/TechStackItem');

const dbUrl = "mongodb://test:ptest@ds245885.mlab.com:45885/tech-stack-db";
mongoose.Promise = global.Promise;
mongoose.connect(dbUrl, (err) => {
    if (err) {
        console.log("Connection error!!");
        console.log(err);
    } else {
        console.log("Connection successful");
    }
});

router.get('/stacks', (req, res) => {
    TechStackItem.find({})
        .exec((err, stacks) => {
            if (err) {
                console.log(err);
            } else {
                res.json(stacks);
            }
        })
});


router.get('/stacks/:id', (req, res) => {
    TechStackItem.findById(req.params.id)
        .exec((err, stack) => {
            if (err) {
                console.log(err);
            } else {
                res.json(stack);
            }
        })
});

router.post('/stack', (req, res) => {
    console.log(req.body);
    var stackItem = new TechStackItem();
    stackItem.name = req.body.name;
    stackItem.category = req.body.category;
    stackItem.save((err, newStackItem) => {
        if (err) {
            console.log(err);
        } else {
            res.json(newStackItem);
        }
    })
});

router.put('/stack/:id', (req, res) => {

    TechStackItem.findByIdAndUpdate(req.params.id,
        {
            $set: { name: req.body.name, category: req.body.category }
        },
        {
            new: true
        },
        (err, updatedStack) => {
            if (err) {
                console.log(err);
            } else {
                res.json(updatedStack);
            }
        }
    );
})


router.delete('/stack/:id', (req, res) => {
    TechStackItem.findByIdAndRemove(req.params.id)
        .exec((err, stack) => {
            if (err) {
                console.log(err);
            } else {
                res.json(stack);
            }
        })
});



module.exports = router;
