import React from 'react';
import {Row, Col} from 'reactstrap';
import CardImage from "./CardImage";

const CardWindow = ({cards}) => (
    <Row>
        {cards.map(card => <Col><CardImage src={card.img} alt={card.name} /></Col>)}
    </Row>
);

export default CardWindow;