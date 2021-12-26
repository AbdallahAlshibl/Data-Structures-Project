
class SLL<T> {
	protected SLLNode<T> head, tail;
	private MSLLNode<T> msllNode;
	private MSLL<T> msll;

	public MSLL<T> getMsll() {
		return msll;
	}

	public void setMsll(MSLL<T> msll) {
		this.msll = msll;
	}

	public MSLLNode<T> getMsllNode() {
		return msllNode;
	}

	public void setMsllNode(MSLLNode<T> msllNode) {
		this.msllNode = msllNode;
	}

	public SLL() {
		head = tail = null;
	}

	public double getDistance(String city1, String city2) throws ExceptionType {
		double distance = 0.0;
		City cityObj1 = null;
		City cityObj2 = null;
		for (City city : MSLLNode.cityArrayList) {
			if ((city.getCityName()).equals(city1)) {
				cityObj1 = city;
			}
			if ((city.getCityName()).equals(city2)) {
				cityObj2 = city;
			}
		}
		if (cityObj1 == null) {
			throw new ExceptionType(city1 + " not exists");
		}
		if (cityObj2 == null) {
			throw new ExceptionType(city2 + " not exists");
		}
		double dLat = Math.toRadians(cityObj2.getDecimalLatitude() - cityObj1.getDecimalLatitude());
		double dLon = Math.toRadians(cityObj2.getDecimalLongitude() - cityObj1.getDecimalLongitude());

		double lat1 = Math.toRadians(cityObj1.getDecimalLatitude());
		double lat2 = Math.toRadians(cityObj2.getDecimalLatitude());

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double rad = 6372.8;
		double c = 2 * Math.asin(Math.sqrt(a));
		distance = rad * c;
		if (false) {
			MSLLNode<T> head1 = getMsll().getMSLLNodeByInfo("" + city1.charAt(0));
			if (head1 != null) {
				cityObj1 = findCity(head1, city1);
				if (cityObj1 == null) {
					throw new ExceptionType(city1 + " not exists");
				}
			} else {
				throw new ExceptionType(city1 + " not exists");
			}
			MSLLNode<T> head2 = getMsll().getMSLLNodeByInfo("" + city2.charAt(0));
			if (head2 != null) {
				cityObj2 = findCity(head1, city1);
				if (cityObj2 == null) {
					throw new ExceptionType(city2 + " not exists");
				}
			} else {
				throw new ExceptionType(city2 + " not exists");
			}
		}
		System.out.println("Distance is " + distance);
		return distance;
	}

	public void addCityToSublistAtRear(City cityObject) {
		if (head != null) {
			tail = new SLLNode(cityObject);
			tail = tail.next;
		} else {
			head = tail = (SLLNode) new SLLNode(cityObject);
		}
		MSLLNode.cityArrayList.add(cityObject);
		++MSLLNode.count;
	}

	public void addToCitySublistList(City c1, int position) throws ExceptionType {
		if (cityIsInSubList(c1)) {
			throw new ExceptionType("City already exists");
		}
		boolean add = false;
		if (position > (MSLLNode.count + 1) || MSLLNode.cityArrayList.size() <= position) {
			throw new ExceptionType("Not Valid Position");
		} else {
			MSLLNode.cityArrayList.add(position, c1);
			MSLLNode.count++;
			add = true;
		}
		if (!add) {
			if (head != null) {
				SLLNode<T> tempNode = new SLLNode(c1);
				int i = 0;
				SLLNode<T> current = head;
				SLLNode<T> previous = head;
				while (i < position) {
					previous = current;
					current = current.next;
					if (current == null) {
						break;
					}
					i++;
				}
				tempNode.next = current;
				previous.next = tempNode;
			} else {
				if (position != 0) {
					throw new ExceptionType("Not Valid Position");
				} else {
					head = tail = new SLLNode(c1);
				}
			}
		}
	}

	public boolean cityIsInSubList(City city) {
		for (City city1 : MSLLNode.cityArrayList) {
			if (city1.getCityName().equals(city.getCityName())) {
				return true;
			}
		}
		if (!MSLLNode.cityArrayList.contains(city)) {
			SLLNode<T> tempHead = head;
			while (tempHead != null) {
				if (tempHead.getInfo() == city.getCityName()) {
					return true;
				}
				tempHead = tempHead.next;
			}
			return false;
		} else {
			return true;
		}
	}

	public void deleteCityFromSublist(City city) throws ExceptionType {
		if (cityIsInSubList(city)) {
			throw new ExceptionType("City is not present");
		}
		MSLLNode.cityArrayList.remove(city);
		if (head != null) {
			SLLNode<T> current = head;
			SLLNode<T> previous = head;
			if (current != null && current.getInfo() == city.getCityName()) {
				head = head.next;
				return;
			}
			while (current != null && current.getInfo() != city.getCityName()) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
		}
	}

	public City findCity(MSLLNode<T> cityMHead, String cityName) {
		for (City city : MSLLNode.cityArrayList) {
			if (city.getCityName().equals(cityName)) {
				return city;
			}
		}
		SLLNode<T> tempHead = cityMHead.getHead();
		while (tempHead != null) {
			if (tempHead.getInfo() == cityName) {
				return (City) tempHead.getInfo();
			}
			tempHead = tempHead.next;
		}
		return null;
	}
}
