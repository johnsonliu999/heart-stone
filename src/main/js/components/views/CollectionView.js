import React from 'react'
import CardWindow from "../CardWindow";

const CollectionView = ({name, cards}) => (
    <div>
        <div>{name}</div>
        <CardWindow cards={cards}/>
    </div>
);

export default CollectionView;