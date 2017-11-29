import React, { Component } from 'react'
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import RecipesList from '../components/RecipeList';
import RecipeDetails from '../components/RecipeDetails';
import Layout from '../components/Layout';




export default class App extends Component {
 
      render() {
        return (
         
            <div>
              <Layout></Layout>

            </div>
         
        );
      }
    }