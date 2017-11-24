import React from 'react';
import ReactDOM from 'react-dom';

import registerServiceWorker from './registerServiceWorker';

import SearchRecipes from './components/SearchRecipes';

//Create a new component.This component should produce some HTML

const App = () => {
    return (
        <div>
            <SearchRecipes />
        </div>
    );
}


ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();

