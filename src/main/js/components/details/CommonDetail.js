import React from 'react';
import {ListGroup, ListGroupItem} from 'reactstrap';
import {Row, Col} from 'reactstrap';

const CommonDetail = ({card}) => {
    const model = {
        "ID": card.cardId,
        "Name": card.name,
        "Set": card.cardSet,
        "Type": card.type,
        "Text": card.text,
        "Class": card.playerClass
    };


    // convert model to list items
    const items = [];
    for (let key in model) {
        items.push(
            <ListGroupItem>
                <Row>
                    <Col><strong>{key}</strong></Col>
                    <Col>{model[key]}</Col>
                </Row>
            </ListGroupItem>
        );
    }

    return (
        <ListGroup>
            {items}
        </ListGroup>
    );
};

export default CommonDetail;