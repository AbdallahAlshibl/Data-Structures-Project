class MSLL<T> {
    protected MSLLNode<T> head, tail;

    public MSLL() {
        head = tail = null;
	}

    public boolean isEmpty() {
        return head == null;
    }

    public void deleteCitySublist(String str) throws ExceptionType {

        if (!isInMSLList(str)) {
            throw new ExceptionType("City doesn't exists");
        }
        for (City city: MSLLNode.cityArrayList) {
            if ((city.getCityName().charAt(0) + "").equals(str)) {
                MSLLNode.cityArrayList.remove(city);
                --MSLLNode.count;
            }
        }
        for (String msll: SLLNode.msllNodeArrayList) {
            if (msll.equals(str)) {
                SLLNode.msllNodeArrayList.remove(msll);
                --SLLNode.msllCount;
            }
            return;
        }
        MSLLNode<T> tempHead = head;
        if (tempHead != null) {
            MSLLNode<T> current = head;
            MSLLNode<T> previous = head;
            if (current != null && current.getInfo().equals(str)) {
                head = head.getNext();
                return;
            }
            while (current != null && !current.getInfo().equals(str)) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(current != null ? current.getNext() : null);
        }
    }

    public void makeCitySublistEmpty(String str) throws ExceptionType {
        if (!isInMSLList(str)) {
            throw new ExceptionType("City doesn't exists");
        }
        for (City city: MSLLNode.cityArrayList) {
            if ((city.getCityName().charAt(0) + "").equals(str)) {
                MSLLNode.cityArrayList.remove(city);
                --MSLLNode.count;
            }
            return;
        }
        MSLLNode<T> tempHead = head;
        if (tempHead != null) {
            MSLLNode<T> current = head;
            if (current != null && current.getInfo().equals(str)) {
                head.setHead(null);
                head.setTail(null);
                return;
            }
            while (current != null && !current.getInfo().equals(str)) {
                current = current.getNext();
            }
            head.setHead(null);
            head.setTail(null);
        }
    }

    public void displayCitySublist(String s1) throws ExceptionType {
        if (!isInMSLList(s1)) {
            throw new ExceptionType("Node doesn't exists");
        }
        System.out.println("City Sublist is as follows: ");
        if (MSLLNode.cityArrayList.isEmpty()) {
            throw new ExceptionType("City sublist is empty");
        }
        for (City city: MSLLNode.cityArrayList) {
            if ((city.getCityName().charAt(0) + "").equals(s1)) {
                System.out.println("City name = " + city.getCityName());
                System.out.println("City Latitude = " + city.getDecimalLatitude());
                System.out.println("City Longitude = " + city.getDecimalLongitude());
            }
            return;
        }
        MSLLNode<T> tempHead = head;
        if (tempHead != null) {
            MSLLNode<T> current = head;
            if (current != null && current.getInfo().equals(s1)) {
                head.setHead(null);
                head.setTail(null);
                return;
            }
            while (current != null && !current.getInfo().equals(s1)) {
                current = current.getNext();
            }
            head.setHead(null);
            head.setTail(null);
        }

        SLLNode<T> currentCity = head.getHead();

        if (currentCity == null) {
            throw new ExceptionType("City sublist is empty");
        }
        System.out.println("City Sublist is as follows: ");
        while (currentCity != null) {
            System.out.println(currentCity.getInfo());
            currentCity = currentCity.next;
        }
    }

    public void addToMSLLHead(String sl) throws ExceptionType {
        MSLLNode<T> temp = new MSLLNode<>();
        temp.setInfo(sl);
        if (!isInMSLList(sl)) {
            SLLNode.msllNodeArrayList.add(0, sl);
            ++SLLNode.msllCount;
            if (tail == null)
                tail = head = temp;
            else {
                temp.setNext(head);
                head = temp;
            }
        } else {
            throw new ExceptionType("Already Exists");
        }
    }

    public void addToMSLLTail(String sl) throws ExceptionType {
        MSLLNode<T> temp = new MSLLNode<>();
        temp.setInfo(sl);
        if (!isInMSLList(sl)) {
            SLLNode.msllNodeArrayList.add(++SLLNode.msllCount, sl);
            if (!isEmpty()) {
                tail.setNext(temp);
                tail = tail.getNext();
            } else {
                head = tail = temp;
            }
        } else {
            throw new ExceptionType("Already Exists");
        }
    }

    public MSLLNode<T> addToMSLL(String sl) {
        SLLNode.msllNodeArrayList.add(sl);
        ++SLLNode.msllCount;
        MSLLNode<T> temp = new MSLLNode<>();
        temp.setInfo(sl);
        MSLLNode<T> tmp = head;
        boolean isFound = false;
        if (!isInMSLList(sl)) {
            SLLNode.msllNodeArrayList.add(++SLLNode.msllCount, sl);
        }
            if (isFound) {
                while (tmp != null) {
                    if (tmp.getInfo().equals(sl)) {
                        isFound = true;
                        return tmp;
                    }
                    tmp = tmp.getNext();
                }
                tail.setNext(temp);
                tail = tail.getNext();
            } 
        return new MSLLNode<>();
    }

    public boolean isInMSLList(String sl) {
        for (City city: MSLLNode.cityArrayList) {
            if ((city.getCityName().charAt(0) + "").equals(sl)) {
                return true;
            }
        }
        MSLLNode<T> tmp = head;
        while (tmp != null) {
            if (tmp.getInfo().equals(sl)) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    public MSLLNode<T> getMSLLNodeByInfo(String sl) {
        for (City city: MSLLNode.cityArrayList) {
            if (sl.equals(city.getCityName().charAt(0) + "")) {
                return new MSLLNode<>();
            }
        }
        MSLLNode<T> tmp = head;
        while (tmp != null) {
            if (tmp.getInfo().equals(sl)) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }
}

class ExceptionType extends Exception {
    ExceptionType(String s) {
        super(s);
    }
}
