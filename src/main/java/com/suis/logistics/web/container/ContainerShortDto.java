package com.suis.logistics.web.container;

public class ContainerShortDto {

	private int noOfContainer;
	private String containerType;
	private String commodity;

	public int getNoOfContainer() {
		return noOfContainer;
	}
	public void setNoOfContainer(int noOfContainer) {
		this.noOfContainer = noOfContainer;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodity == null) ? 0 : commodity.hashCode());
		result = prime * result + ((containerType == null) ? 0 : containerType.hashCode());
		result = prime * result + noOfContainer;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContainerShortDto other = (ContainerShortDto) obj;
		if (commodity == null) {
			if (other.commodity != null)
				return false;
		} else if (!commodity.equals(other.commodity))
			return false;
		if (containerType == null) {
			if (other.containerType != null)
				return false;
		} else if (!containerType.equals(other.containerType))
			return false;
		if (noOfContainer != other.noOfContainer)
			return false;
		return true;
	}



}
