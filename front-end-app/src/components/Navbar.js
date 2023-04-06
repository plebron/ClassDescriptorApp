import { Container, Tab, Tabs } from 'react-bootstrap';
import NewNote from '../screens/newNote';

const Navbar = () => (
    <Container>
        <Tabs defaultActiveKey="new-note" className="mb-3">
            <Tab eventKey="new-note" title="New note">
                <Container>
                    <NewNote/>
                </Container>
            </Tab>
            <Tab eventKey="note-1" title="Note 1">
                <h3>Tab2</h3>
            </Tab>
            <Tab eventKey="note-2" title="Note 2">
                <h3>contact</h3>
            </Tab>
        </Tabs>
    </Container>
);

export default Navbar;