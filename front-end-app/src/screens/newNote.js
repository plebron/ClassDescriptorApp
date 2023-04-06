import { React, useState, useEffect } from 'react'
import {Button, Form, Row, Col} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const newNote = () => {
    const [form, setfForm] = useState({ noteEntry: '' })

    function handleChange(event) {
        const {value, name} = event.target
        setForm({ ...form, [name]: value })
    }
    
    return (
     <Form>
        <Row>
            <Col md={8} xs={6}>
                <Form.Label>Nueva nota:</Form.Label>
            </Col>
            <Col md={3} xs={6}>
                <Button variant="primary" type="submit">Eliminar</Button>
            </Col> 
        </Row>
    
        <Row>
            <Form.Control value={form.noteEntry} onChange={handleChange} as="textarea" placeholder="Introduzca su nota aqui" rows={10}/>
        </Row>
    </Form>
  )
}

export default newNote