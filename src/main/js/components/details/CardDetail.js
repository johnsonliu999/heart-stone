import React from 'react';
import {ListGroup, ListGroupItem} from 'reactstrap';
import {Row, Col} from 'reactstrap';
import _ from 'lodash'
import {API_URL} from "../../consts";

import CardImage from '../CardImage'

const COMMON_MAP = {
    "cardId":'ID',
    "name":"Name",
    "cardSet":"Set",
    "type":"Type",
    "text":"Text",
    "playerClass":"Class"
};

const OTHER_MAP = {
    'rarity':'Rarity',
    'faction':'Faction',
    'race': 'Race',
    'attack':'Attack',
    'health':'Health',
    'cost':'Cost',
    'durability': 'Durability',
    'flavor':'Flavor',
    'artist':'Artist',
    'collectible':'Collectible',
    'mechanics':'Mechanics',
    'elite': 'Elite'
};

const SPECIALITIES = ["mechanics", "collectible"];

// prop -> search_prefix
const SEARCH_PREFIX_MAP = {
    'playerClass': 'classes',
    'faction': 'factions',
    'rarity': 'qualities',
    'race': 'races',
    'type': 'types',
    'cardSet': 'sets'
};

/*
    specifics: a object with display_name -> mapped_prop
 */
const CardDetail = ({card}) => {
    
    function mapToItems(map) {
        const items = [];
        for (let key in map) {
            if (card[key] && !_.includes(SPECIALITIES, key))
                items.push(
                    <ListGroupItem key={key}>
                        <Row>
                            <Col>{map[key]}</Col>
                            <Col>
                                {SEARCH_PREFIX_MAP[key] ?
                                <a href={`${API_URL}/${SEARCH_PREFIX_MAP[key]}/${card[key]}`}>{card[key]}</a>
                                : card[key]}
                            </Col>
                        </Row>
                    </ListGroupItem>
                )
        }
        return items;
    }

    return (
        <div>
            <CardImage src={card.img} name={card.name}/>
            <div>
                <h3>Commons</h3>
                <ListGroup>
                    {mapToItems(COMMON_MAP)}
                </ListGroup>
            </div>
            <div>
                <h3>Specifics</h3>
                <ListGroup>
                    {mapToItems(OTHER_MAP)}
                </ListGroup>
            </div>
        </div>
    );
};

export default CardDetail;