import React from 'react'
import {ListGroup, ListGroupItem, ListGroupItemHeading, ListGroupItemText} from 'reactstrap'
import {Row, Col} from 'reactstrap'

const SearchResult = ({cards, handleResultClick}) => {
    return (
        <ListGroup>
            {cards.map(card => (
                <ListGroupItem key={card.cardId} onClick={() => handleResultClick(card)}>
                    <ListGroupItemHeading>{card.name}</ListGroupItemHeading>
                    <Row>
                        <Col>{card.type}</Col>
                        <Col>{card.playerClass}</Col>
                        <Col>{card.cardSet}</Col>
                    </Row>
                </ListGroupItem>
            ))}
        </ListGroup>
    );
};

export default SearchResult;