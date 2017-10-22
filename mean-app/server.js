//Get dependencies
const express = require('express');
const path = require('path');
const http = require('http');
const bodyParser = require('body-parser');

// Get API routes
const api = require('./server/routes/api');
const app = express();

//Parsers for post data
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

//Point static path to dist
app.use(express.static(path.join(__dirname, 'dist')));

// Set api routes
app.use('/api', api);

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'dist/index.html'));
});

//Get port from env and store in express
const port = process.env.PORT || '3000';
app.set('port', port);

//Create HTTP server
const server = http.createServer(app);

// Listen on proved port on all network interfaces
server.listen(port, () => console.log(`API running on localhost :${port}`));

