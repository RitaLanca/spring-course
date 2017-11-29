import React from 'react';
import ReactDOM from 'react-dom';
import registerServiceWorker from './registerServiceWorker';


//middlewares, redux
import { Provider } from 'react-redux'; //Injects Redux to comps
import { createStore, applyMiddleware } from 'redux';


// components
import App from './components/App';

/*
import { Router, browserHistory } from 'react-router';
import routes from './routes'; // Navigation

import SearchRecipes from './components/SearchRecipes';
*/


//let store = createStore(rootReducer);


ReactDOM.render( 
    <Provider>
        <App/>
    </Provider>    
    , document.getElementById('root'));
registerServiceWorker();

