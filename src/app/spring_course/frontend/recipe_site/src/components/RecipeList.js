import React, { Component } from 'react';


renderCategories(categories) {
    return categories.map((c) => {
       c = c.trim();
       return (
         <Link to={"filter/" + c} key={c} className="list-group-item-text">{" " + c + " "}</Link>
       );
    });
 }
