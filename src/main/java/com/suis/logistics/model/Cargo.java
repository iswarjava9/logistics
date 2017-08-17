package com.suis.logistics.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the cargo database table.
 *
 */
@Entity
@Table(name="cargo")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="cartoon_hieght")
	private Double cartoonHieght;

	@Column(name="cartoon_length")
	private Double cartoonLength;

	@Column(name="cartoon_width")
	private Double cartoonWidth;

	private Integer cartoons;

	@Column(name="contents_description")
	private String contentsDescription;

	@Column(name="gross_cbm")
	private String grossCbm;

	@Column(name="gross_cft")
	private String grossCft;

	@Column(name="gross_kgs")
	private String grossKgs;

	@Column(name="gross_lbs")
	private String grossLbs;

	@Column(name="hts_id")
	private Integer htsId;

	@Column(name="net_cbm")
	private String netCbm;

	@Column(name="net_cft")
	private String netCft;

	@Column(name="net_kgs")
	private String netKgs;

	@Column(name="net_lbs")
	private String netLbs;

	@Column(name="no_of_pieces")
	private Integer noOfPieces;

	private String unit;

	//bi-directional many-to-one association to CargoTemplate
	@OneToOne
	@JoinColumn(name="cargo_template_id")
	private CargoTemplate cargoTemplate;

	//bi-directional many-to-one association to Commodity
	@OneToOne
	@JoinColumn(name="schedule_b_id")
	private Commodity commodity;

	//bi-directional many-to-one association to ContainerDetail
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="container_id")
	private ContainerDetail containerDetail;

	//bi-directional many-to-one association to PieceType
	@OneToOne
	@JoinColumn(name="piece_type_id")
	private PieceType pieceType;

	public Cargo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Double getCartoonHieght() {
		return cartoonHieght;
	}

	public void setCartoonHieght(Double cartoonHieght) {
		this.cartoonHieght = cartoonHieght;
	}

	public Double getCartoonLength() {
		return cartoonLength;
	}

	public void setCartoonLength(Double cartoonLength) {
		this.cartoonLength = cartoonLength;
	}

	public Double getCartoonWidth() {
		return cartoonWidth;
	}

	public void setCartoonWidth(Double cartoonWidth) {
		this.cartoonWidth = cartoonWidth;
	}

	public Integer getCartoons() {
		return this.cartoons;
	}

	public void setCartoons(Integer cartoons) {
		this.cartoons = cartoons;
	}

	public String getContentsDescription() {
		return this.contentsDescription;
	}

	public void setContentsDescription(String contentsDescription) {
		this.contentsDescription = contentsDescription;
	}

	public String getGrossCbm() {
		return this.grossCbm;
	}

	public void setGrossCbm(String grossCbm) {
		this.grossCbm = grossCbm;
	}

	public String getGrossCft() {
		return this.grossCft;
	}

	public void setGrossCft(String grossCft) {
		this.grossCft = grossCft;
	}

	public String getGrossKgs() {
		return this.grossKgs;
	}

	public void setGrossKgs(String grossKgs) {
		this.grossKgs = grossKgs;
	}

	public String getGrossLbs() {
		return this.grossLbs;
	}

	public void setGrossLbs(String grossLbs) {
		this.grossLbs = grossLbs;
	}

	public Integer getHtsId() {
		return this.htsId;
	}

	public void setHtsId(Integer htsId) {
		this.htsId = htsId;
	}

	public String getNetCbm() {
		return this.netCbm;
	}

	public void setNetCbm(String netCbm) {
		this.netCbm = netCbm;
	}

	public String getNetCft() {
		return this.netCft;
	}

	public void setNetCft(String netCft) {
		this.netCft = netCft;
	}

	public String getNetKgs() {
		return this.netKgs;
	}

	public void setNetKgs(String netKgs) {
		this.netKgs = netKgs;
	}

	public String getNetLbs() {
		return this.netLbs;
	}

	public void setNetLbs(String netLbs) {
		this.netLbs = netLbs;
	}

	public Integer getNoOfPieces() {
		return this.noOfPieces;
	}

	public void setNoOfPieces(Integer noOfPieces) {
		this.noOfPieces = noOfPieces;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public CargoTemplate getCargoTemplate() {
		return this.cargoTemplate;
	}

	public void setCargoTemplate(CargoTemplate cargoTemplate) {
		this.cargoTemplate = cargoTemplate;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public ContainerDetail getContainerDetail() {
		return this.containerDetail;
	}

	public void setContainerDetail(ContainerDetail containerDetail) {
		this.containerDetail = containerDetail;
	}

	public PieceType getPieceType() {
		return this.pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

}